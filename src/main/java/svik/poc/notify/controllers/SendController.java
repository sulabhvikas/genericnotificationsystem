package svik.poc.notify.controllers;

import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import svik.poc.notify.exceptions.NotificationException;
import svik.poc.notify.models.NotificationMessage;
import svik.poc.notify.models.NotificationMessage.Channel;
import svik.poc.notify.queue.ApplicationConstant;
import svik.poc.notify.services.NotificationService;
import svik.poc.notify.utils.NotificationRegexPatterns;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Notification Send REST API v1",  tags = "Notification Send API")
public class SendController {
	
	private static final Logger log = LoggerFactory.getLogger(SendController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private Environment env;

	/**
	 * Send messages to specified channel
	 * @author sulabhvikas
	 * @param
	 * @return
	 * @throws NotificationException 
	 */
	//@PostMapping("/send")
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	@ApiOperation(value = "send application notifications to customers on different channels", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    })
	public ResponseEntity<?> send(@RequestBody NotificationMessage message, 
				@RequestHeader(name = "X-AUTH_TOKEN", required = false) Map<String, String> headers) throws NotificationException {
		
		try {
			System.out.println("POST - Request Body: " + message.toString());
			
			NotificationMessage validatedMessage = validateRequest(message);
			
			notificationService.invokeSendProcess(validatedMessage);
			
			return new ResponseEntity<String>(ApplicationConstant.IN_QUEUE, HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Exception occurred while sending message to the queue. Exception= {}", ex);
			return new ResponseEntity(ApplicationConstant.MESSAGE_QUEUE_SEND_ERROR,
										HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	NotificationMessage validateRequest(NotificationMessage message) throws NotificationException {
		try {
			NotificationMessage validatedMessage = validateCorrelationId(message);
			validateBody(message);
	        if (Channel.sms.equals(message.getChannel())) {
	            validatePhone(message.getTo());
	            validateEmail(message.getFrom());
	        }
	        if (Channel.email.equals(message.getChannel())) {
	            validateEmail(message.getTo());
	            validateEmail(message.getFrom());
	        }
			return validatedMessage;
		} catch (NotificationException e) {
			throw e;
		} catch (Exception e) {
			throw new NotificationException(NotificationException.BAD_REQUEST);
		}
		
	}

	private NotificationMessage validateCorrelationId(NotificationMessage message) throws NotificationException {
		
		String correlationId = message.getCorrelationId();
		String authorizedApplications = env.getProperty("authorized.applications");
		String[] authorizedApplicationList = authorizedApplications.split(",");
		if (correlationId != null && !correlationId.trim().isEmpty()) {
			String[] correlationIdParts = correlationId.split("_");
			if (correlationIdParts.length == 3) {
				boolean callingSystemMatch = false;
				for (int i = 0; i < authorizedApplicationList.length; i++) {
					if (authorizedApplicationList[i].equalsIgnoreCase(correlationIdParts[0])) {
						message.setApplicationId(correlationIdParts[0]);
						callingSystemMatch = true;
					}
				}

				if (!callingSystemMatch) {
					throw new NotificationException(NotificationException.BAD_REQUEST+
							correlationIdParts[0] + " is not a supported calling system.");
				}

			} else {
				throw new NotificationException(NotificationException.BAD_REQUEST+
						"'correlationId' should be of the pattern 'CallingSystemName'_'TimeStamp'_'Sequence'");
			}

		} else {
			throw new NotificationException(NotificationException.BAD_REQUEST+
					"'correlationId' is a mandatory field in the request and should be of the pattern 'CallingSystemName'_'TimeStamp'_'Sequence'");
		}
		
		return message;
	}

	private void validateBody(NotificationMessage message) throws NotificationException {
		if (message == null || message.getText() == null) {
			throw new NotificationException(NotificationException.BAD_REQUEST+
					"A message cannot be empty, either provide the message body or provide the template to use");
		}
	}
	
    private void validateEmail(String toField) throws NotificationException {
        Pattern pattern = NotificationRegexPatterns.EMAIL_ADDRESS;
        if (!(pattern.matcher(toField).matches())) {
            throw new NotificationException(NotificationException.BAD_REQUEST+ "Sorry, email is Invalid");
        }
    }

    private void validatePhone(String toField) throws NotificationException {
        Pattern pattern = NotificationRegexPatterns.PHONE_REGEX;
        if (!(pattern.matcher(toField).matches())) {
            throw new NotificationException(NotificationException.BAD_REQUEST+ "Sorry, Phone Number is Invalid");
        }
    }
}
