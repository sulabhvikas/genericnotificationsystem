package svik.poc.notify.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import svik.poc.notify.models.NotificationMessage;

/**
 * Message Listener for RabbitMQ
 */
@Service
public class MessageListener {
    
	private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
    
    @Autowired
    ApplicationConfigReader applicationConfigReader;

    /**
     * Message listener for Ordering app - Email
     * @param UserDetails a user defined object used for deserialization of message
     */
    @RabbitListener(queues = "${ordering.queue1.name}")
    public void receiveMessageForOrderingEmail(final NotificationMessage data) {
    log.info("Received message: {} from Ordering Email queue.", data);
    try {
	    log.info("Making REST call to the API");
	    //TODO: Code to make REST call
	        log.info("<< Exiting receiveMessageForOrderingEmail() after API call."+data.toString());
	    } catch(HttpClientErrorException  ex) {
		    if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
		        log.info("Delay...");
		        try {
		        	Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
			    } catch (InterruptedException e) { }
			    log.info("Throwing exception so that message will be requed in the queue.");
			    // Note: Typically Application specific exception should be thrown below
			    throw new RuntimeException();
		    } else {
		    	throw new AmqpRejectAndDontRequeueException(ex); 
		    }
	    } catch(Exception e) {
		    log.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
		    throw new AmqpRejectAndDontRequeueException(e); 
	    }
    }
    
    /**
     * Message listener for Ordering app - Sms
     * @param UserDetails a user defined object used for deserialization of message
     */
    @RabbitListener(queues = "${ordering.queue2.name}")
    public void receiveMessageForOrderingSms(final NotificationMessage data) {
    log.info("Received message: {} from Ordering Email queue.", data);
    try {
	    log.info("Making REST call to the API");
	    //TODO: Code to make REST call
	        log.info("<< Exiting receiveMessageForOrderingSms() after API call."+data.toString());
	    } catch(HttpClientErrorException  ex) {
		    if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
		        log.info("Delay...");
		        try {
		        	Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
			    } catch (InterruptedException e) { }
			    log.info("Throwing exception so that message will be requed in the queue.");
			    // Note: Typically Application specific exception should be thrown below
			    throw new RuntimeException();
		    } else {
		    	throw new AmqpRejectAndDontRequeueException(ex); 
		    }
	    } catch(Exception e) {
		    log.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
		    throw new AmqpRejectAndDontRequeueException(e); 
	    }
    }
    
    /**
     * Message listener for Ordering app - Twitter
     * @param UserDetails a user defined object used for deserialization of message
     */
    @RabbitListener(queues = "${ordering.queue3.name}")
    public void receiveMessageForOrderingTwitter(final NotificationMessage data) {
    log.info("Received message: {} from Ordering Email queue.", data);
    try {
	    log.info("Making REST call to the API");
	    //TODO: Code to make REST call
	        log.info("<< Exiting receiveMessageForOrderingTwitter() after API call."+data.toString());
	    } catch(HttpClientErrorException  ex) {
		    if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
		        log.info("Delay...");
		        try {
		        	Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
			    } catch (InterruptedException e) { }
			    log.info("Throwing exception so that message will be requed in the queue.");
			    // Note: Typically Application specific exception should be thrown below
			    throw new RuntimeException();
		    } else {
		    	throw new AmqpRejectAndDontRequeueException(ex); 
		    }
	    } catch(Exception e) {
		    log.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
		    throw new AmqpRejectAndDontRequeueException(e); 
	    }
    }
    
    /**
     * Message listener for ticketing app - Email
     * @param UserDetails a user defined object used for deserialization of message
     */
    @RabbitListener(queues = "${ticketing.queue1.name}")
    public void receiveMessageForTicketingEmail(final NotificationMessage data) {
    log.info("Received message: {} from Ordering Email queue.", data);
    try {
	    log.info("Making REST call to the API"+data.toString());
	    //TODO: Code to make REST call
	        log.info("<< Exiting receiveMessageForTicketingEmail() after API call."+data.toString());
	    } catch(HttpClientErrorException  ex) {
		    if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
		        log.info("Delay...");
		        try {
		        	Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
			    } catch (InterruptedException e) { }
			    log.info("Throwing exception so that message will be requed in the queue.");
			    // Note: Typically Application specific exception should be thrown below
			    throw new RuntimeException();
		    } else {
		    	throw new AmqpRejectAndDontRequeueException(ex); 
		    }
	    } catch(Exception e) {
		    log.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
		    throw new AmqpRejectAndDontRequeueException(e); 
	    }
    }
    
    /**
     * Message listener for ticketing app - Sms
     * @param UserDetails a user defined object used for deserialization of message
     */
    @RabbitListener(queues = "${ticketing.queue2.name}")
    public void receiveMessageForTicketingSms(final NotificationMessage data) {
    log.info("Received message: {} from Ordering Email queue.", data);
    try {
	    log.info("Making REST call to the API");
	    //TODO: Code to make REST call
	        log.info("<< Exiting receiveMessageForTicketingSms() after API call."+data.toString());
	    } catch(HttpClientErrorException  ex) {
		    if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
		        log.info("Delay...");
		        try {
		        	Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
			    } catch (InterruptedException e) { }
			    log.info("Throwing exception so that message will be requed in the queue.");
			    // Note: Typically Application specific exception should be thrown below
			    throw new RuntimeException();
		    } else {
		    	throw new AmqpRejectAndDontRequeueException(ex); 
		    }
	    } catch(Exception e) {
		    log.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
		    throw new AmqpRejectAndDontRequeueException(e); 
	    }
    }
    
    /**
     * Message listener for ticketing app - Twitter
     * @param UserDetails a user defined object used for deserialization of message
     */
    @RabbitListener(queues = "${ticketing.queue3.name}")
    public void receiveMessageForTicketingTwitter(final NotificationMessage data) {
    log.info("Received message: {} from Ordering Email queue.", data);
    try {
	    log.info("Making REST call to the API");
	    //TODO: Code to make REST call
	        log.info("<< Exiting receiveMessageForTicketingTwitter() after API call."+data.toString());
	    } catch(HttpClientErrorException  ex) {
		    if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
		        log.info("Delay...");
		        try {
		        	Thread.sleep(ApplicationConstant.MESSAGE_RETRY_DELAY);
			    } catch (InterruptedException e) { }
			    log.info("Throwing exception so that message will be requed in the queue.");
			    // Note: Typically Application specific exception should be thrown below
			    throw new RuntimeException();
		    } else {
		    	throw new AmqpRejectAndDontRequeueException(ex); 
		    }
	    } catch(Exception e) {
		    log.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
		    throw new AmqpRejectAndDontRequeueException(e); 
	    }
    }
}

