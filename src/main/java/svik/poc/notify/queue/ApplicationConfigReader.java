package svik.poc.notify.queue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfigReader {
	/**
	 * # Message Queue specific configs for ordering
		ordering.exchange.name=ordering-exchange
		ordering.queue1.name=ordering-email-queue
		ordering.routing1.key=ordering-email-routing-key
		ordering.queue2.name=ordering-sms-queue
		ordering.routing2.key=ordering-sms-routing-key
		ordering.queue3.name=ordering-twitter-queue
		ordering.routing3.key=ordering-twitter-routing-key
		# Message Queue specific configs for ticketing
		ticketing.exchange.name=ticketing-exchange
		ticketing.queue1.name=ticketing-email-queue
		ticketing.routing1.key=ticketing-email-routing-key
		ticketing.queue2.name=ticketing-sms-queue
		ticketing.routing2.key=ticketing-sms-routing-key
		ticketing.queue3.name=ticketing-twitter-queue
		ticketing.routing3.key=ticketing-twitter-routing-key
	 */
	
	
	@Value("${ordering.exchange.name}")
	private String orderingExchange;
	@Value("${ordering.queue1.name}")
	private String orderingEmailQueue;
	@Value("${ordering.routing1.key}")
	private String orderingEmailRoutingKey;
	@Value("${ordering.queue2.name}")
	private String orderingSmsQueue;
	@Value("${ordering.routing2.key}")
	private String orderingSmsRoutingKey;
	@Value("${ordering.queue3.name}")
	private String orderingTwitterQueue;
	@Value("${ordering.routing3.key}")
	private String orderingTwitterRoutingKey;
	@Value("${ticketing.exchange.name}")
	private String ticketingExchange;
	@Value("${ticketing.queue1.name}")
	private String ticketingEmailQueue;
	@Value("${ticketing.routing1.key}")
	private String ticketingEmailRoutingKey;
	@Value("${ticketing.queue2.name}")
	private String ticketingSmsQueue;
	@Value("${ticketing.routing2.key}")
	private String ticketingSmsRoutingKey;
	@Value("${ticketing.queue3.name}")
	private String ticketingTwitterQueue;
	@Value("${ticketing.routing3.key}")
	private String ticketingTwitterRoutingKey;
	public String getOrderingExchange() {
		return orderingExchange;
	}
	public void setOrderingExchange(String orderingExchange) {
		this.orderingExchange = orderingExchange;
	}
	public String getOrderingEmailQueue() {
		return orderingEmailQueue;
	}
	public void setOrderingEmailQueue(String orderingEmailQueue) {
		this.orderingEmailQueue = orderingEmailQueue;
	}
	public String getOrderingEmailRoutingKey() {
		return orderingEmailRoutingKey;
	}
	public void setOrderingEmailRoutingKey(String orderingEmailRoutingKey) {
		this.orderingEmailRoutingKey = orderingEmailRoutingKey;
	}
	public String getOrderingSmsQueue() {
		return orderingSmsQueue;
	}
	public void setOrderingSmsQueue(String orderingSmsQueue) {
		this.orderingSmsQueue = orderingSmsQueue;
	}
	public String getOrderingSmsRoutingKey() {
		return orderingSmsRoutingKey;
	}
	public void setOrderingSmsRoutingKey(String orderingSmsRoutingKey) {
		this.orderingSmsRoutingKey = orderingSmsRoutingKey;
	}
	public String getOrderingTwitterQueue() {
		return orderingTwitterQueue;
	}
	public void setOrderingTwitterQueue(String orderingTwitterQueue) {
		this.orderingTwitterQueue = orderingTwitterQueue;
	}
	public String getOrderingTwitterRoutingKey() {
		return orderingTwitterRoutingKey;
	}
	public void setOrderingTwitterRoutingKey(String orderingTwitterRoutingKey) {
		this.orderingTwitterRoutingKey = orderingTwitterRoutingKey;
	}
	public String getTicketingExchange() {
		return ticketingExchange;
	}
	public void setTicketingExchange(String ticketingExchange) {
		this.ticketingExchange = ticketingExchange;
	}
	public String getTicketingEmailQueue() {
		return ticketingEmailQueue;
	}
	public void setTicketingEmailQueue(String ticketingEmailQueue) {
		this.ticketingEmailQueue = ticketingEmailQueue;
	}
	public String getTicketingEmailRoutingKey() {
		return ticketingEmailRoutingKey;
	}
	public void setTicketingEmailRoutingKey(String ticketingEmailRoutingKey) {
		this.ticketingEmailRoutingKey = ticketingEmailRoutingKey;
	}
	public String getTicketingSmsQueue() {
		return ticketingSmsQueue;
	}
	public void setTicketingSmsQueue(String ticketingSmsQueue) {
		this.ticketingSmsQueue = ticketingSmsQueue;
	}
	public String getTicketingSmsRoutingKey() {
		return ticketingSmsRoutingKey;
	}
	public void setTicketingSmsRoutingKey(String ticketingSmsRoutingKey) {
		this.ticketingSmsRoutingKey = ticketingSmsRoutingKey;
	}
	public String getTicketingTwitterQueue() {
		return ticketingTwitterQueue;
	}
	public void setTicketingTwitterQueue(String ticketingTwitterQueue) {
		this.ticketingTwitterQueue = ticketingTwitterQueue;
	}
	public String getTicketingTwitterRoutingKey() {
		return ticketingTwitterRoutingKey;
	}
	public void setTicketingTwitterRoutingKey(String ticketingTwitterRoutingKey) {
		this.ticketingTwitterRoutingKey = ticketingTwitterRoutingKey;
	}


}
