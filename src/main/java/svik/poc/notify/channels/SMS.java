package svik.poc.notify.channels;

import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessagingException;

import svik.poc.notify.models.NotificationMessage;

public class SMS extends Channel {
	
	private static final Logger log = LoggerFactory.getLogger(SMS.class);
	
	@Override
	public boolean sendMessage(NotificationMessage message)
		      throws MessagingException, IOException {
		log.info("SMS::"+message.toString());
		
		return true;
	}
	
}
