package svik.poc.notify.channels;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessagingException;

import svik.poc.notify.models.NotificationMessage;

public class Twitter extends Channel {

	private static final Logger log = LoggerFactory.getLogger(Twitter.class);
	
	@Override
	public boolean sendMessage(NotificationMessage message)
		      throws MessagingException, IOException {
		log.info("Twitter::"+message.toString());
		return true;
	}

}
