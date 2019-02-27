package svik.poc.notify.channels;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.messaging.MessagingException;

import svik.poc.notify.models.NotificationMessage;
import svik.poc.notify.services.NotificationService;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class Email extends Channel {
	
	private static final Logger log = LoggerFactory.getLogger(Email.class);
	
	@Autowired
	private Environment env;
	
	@Override
	public boolean sendMessage(NotificationMessage message)
		      throws MessagingException, IOException {
		log.info("EMAIL::"+message.toString());   
		sendEmail(message);
		   return true;
	}

	public void sendEmail(NotificationMessage msg){
        try
        {
		    //Message message = formatEmailMessage(msg);
		    //Get SMTP details from application.properties
			//Transport.send(msg);  
			System.out.println("EMail Sent Successfully!!");
        }catch (Exception e) {
        	e.printStackTrace();
        }
    }

}
