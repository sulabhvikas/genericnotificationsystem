package svik.poc.notify.services;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import svik.poc.notify.exceptions.NotificationException;
import svik.poc.notify.models.NotificationMessage;
import svik.poc.notify.models.NotificationMessage.Channel;
import svik.poc.notify.queue.ApplicationConfigReader;
import svik.poc.notify.queue.MessageSender;

@Service
public class NotificationService {
	
	private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	private ApplicationConfigReader applicationConfig;
	private MessageSender messageSender;
	
	public ApplicationConfigReader getApplicationConfig() {
		return applicationConfig;
	}
	@Autowired
	public void setApplicationConfig(ApplicationConfigReader applicationConfig) {
		this.applicationConfig = applicationConfig;
	}
	@Autowired
	public NotificationService(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	public MessageSender getMessageSender() {
		return messageSender;
	}
	@Autowired
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
	public void invokeSendProcess(NotificationMessage message) throws NotificationException {
		log.info("In Invoke::"+message.toString());
		
		if ("Ordering".equals(message.getApplicationId())) {
			log.info("IN OUTER IF::"+message.getApplicationId()+message.getChannel());
			if (Channel.sms.equals(message.getChannel())) {
				messageSender.sendMessage(rabbitTemplate, getApplicationConfig().getOrderingExchange(), 
											getApplicationConfig().getOrderingSmsRoutingKey(), message);
				
			} else if (Channel.email.equals(message.getChannel())) {
				log.info("IN inner IF::"+message.getApplicationId()+message.getChannel());
				messageSender.sendMessage(rabbitTemplate, getApplicationConfig().getOrderingExchange(), 
											getApplicationConfig().getOrderingEmailRoutingKey(), message);
				
			} else if (Channel.twitter.equals(message.getChannel())) {
				messageSender.sendMessage(rabbitTemplate, getApplicationConfig().getOrderingExchange(), 
											getApplicationConfig().getOrderingTwitterRoutingKey(), message);
				
			} 
		} else if ("Ticketing".equals(message.getApplicationId())) {
			if (Channel.sms.equals(message.getChannel())) {
				messageSender.sendMessage(rabbitTemplate, getApplicationConfig().getTicketingExchange(), 
											getApplicationConfig().getTicketingSmsRoutingKey(), message);
				
			} else if (Channel.email.equals(message.getChannel())) {
				messageSender.sendMessage(rabbitTemplate, getApplicationConfig().getTicketingExchange(), 
											getApplicationConfig().getTicketingEmailRoutingKey(), message);
				
			} else if (Channel.twitter.equals(message.getChannel())) {
				messageSender.sendMessage(rabbitTemplate, getApplicationConfig().getTicketingExchange(), 
											getApplicationConfig().getTicketingTwitterRoutingKey(), message);
				
			} 		
		}
	}

}
