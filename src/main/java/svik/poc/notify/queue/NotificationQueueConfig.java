package svik.poc.notify.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class NotificationQueueConfig {

	@Autowired
	private ApplicationConfigReader applicationConfig;
	
	public ApplicationConfigReader getApplicationConfig() {
		return applicationConfig;
	}
	public void setApplicationConfig(ApplicationConfigReader applicationConfig) {
		this.applicationConfig = applicationConfig;
	}
	
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        return new RabbitAdmin(connectionFactory);
//    }
	
	/* This bean is to read the properties file configs */
	@Bean
	public ApplicationConfigReader applicationConfig() {
		return new ApplicationConfigReader();
	}
	
	/* Creating a bean for the Message queue Exchange - Ordering*/
	@Bean
	public TopicExchange getOrderingExchange() {
		return new TopicExchange(getApplicationConfig().getOrderingExchange());
	}
	

	/* Creating a bean for the Message queue - Ordering - Email*/
	@Bean
	public Queue getOrderingEmailQueue() {
		return new Queue(getApplicationConfig().getOrderingEmailQueue());
	}
	
	/* Binding between Exchange and Queue using routing key - Ordering - Email */
	@Bean
	public Binding declareBindingOrderingEmail() {
		return BindingBuilder.bind(getOrderingEmailQueue()).to(getOrderingExchange()).with(getApplicationConfig().getOrderingEmailRoutingKey());
	}
	
	/* Creating a bean for the Message queue - Ordering - SMS*/
	@Bean
	public Queue getOrderingSmsQueue() {
		return new Queue(getApplicationConfig().getOrderingSmsQueue());
	}
	
	/* Binding between Exchange and Queue using routing key - Ordering - SMS */
	@Bean
	public Binding declareBindingOrderingSms() {
		return BindingBuilder.bind(getOrderingSmsQueue()).to(getOrderingExchange()).with(getApplicationConfig().getOrderingSmsRoutingKey());
	}
	
	/* Creating a bean for the Message queue - Ordering - Twitter*/
	@Bean
	public Queue getOrderingTwitterQueue() {
		return new Queue(getApplicationConfig().getOrderingTwitterQueue());
	}
	
	/* Binding between Exchange and Queue using routing key - Ordering - Twitter */
	@Bean
	public Binding declareBindingOrderingTwitter() {
		return BindingBuilder.bind(getOrderingTwitterQueue()).to(getOrderingExchange()).with(getApplicationConfig().getOrderingTwitterRoutingKey());
	}

	/* Creating a bean for the Message queue Exchange - Ticketing*/
	@Bean
	public TopicExchange getTicketingExchange() {
		return new TopicExchange(getApplicationConfig().getTicketingExchange());
	}
	
	/* Creating a bean for the Message queue - Ticketing - Email*/
	@Bean
	public Queue getTicketingEmailQueue() {
		return new Queue(getApplicationConfig().getTicketingEmailQueue());
	}
	
	/* Binding between Exchange and Queue using routing key - Ticketing - Email */
	@Bean
	public Binding declareBindingTicketingEmail() {
		return BindingBuilder.bind(getTicketingEmailQueue()).to(getTicketingExchange()).with(getApplicationConfig().getTicketingEmailRoutingKey());
	}
	
	/* Creating a bean for the Message queue - Ticketing - SMS*/
	@Bean
	public Queue getTicketingSmsQueue() {
		return new Queue(getApplicationConfig().getTicketingSmsQueue());
	}
	
	/* Binding between Exchange and Queue using routing key - Ticketing - SMS */
	@Bean
	public Binding declareBindingTicketingSms() {
		return BindingBuilder.bind(getTicketingSmsQueue()).to(getTicketingExchange()).with(getApplicationConfig().getTicketingSmsRoutingKey());
	}
	
	/* Creating a bean for the Message queue - Ticketing - Twitter*/
	@Bean
	public Queue getTicketingTwitterQueue() {
		return new Queue(getApplicationConfig().getTicketingTwitterQueue());
	}
	
	/* Binding between Exchange and Queue using routing key - Ticketing - Twitter */
	@Bean
	public Binding declareBindingTicketingTwitter() {
		return BindingBuilder.bind(getTicketingTwitterQueue()).to(getTicketingExchange()).with(getApplicationConfig().getTicketingTwitterRoutingKey());
	}
	
//	@Bean
//	SimpleMessageListenerContainer orderingEmailListenerContainer(ConnectionFactory connectionFactory,
//			@Qualifier("orderingEmailListenerAdapter") MessageListenerAdapter orderingEmailListenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
///*		String[] queues = new String[2];
////		queues[0] = getApplicationConfig().getOrderingEmailQueue();
////		queues[1] = getApplicationConfig().getOrderingSmsQueue();
////		queues[2] = getApplicationConfig().getOrderingTwitterQueue();
////		queues[3] = getApplicationConfig().getTicketingEmailQueue();
////		queues[4] = getApplicationConfig().getTicketingSmsQueue();
////		queues[5] = getApplicationConfig().getTicketingTwitterQueue();
//		container.setQueueNames(queues);*/
//		container.setQueueNames(getApplicationConfig().getOrderingEmailQueue());
//		container.setMessageListener(orderingEmailListenerAdapter);
//		return container;
//	}
//
//	@Bean(name="orderingEmailListenerAdapter")
//	MessageListenerAdapter orderingEmailListenerAdapter(MessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessageForOrderingEmail");
//	}
//
//	@Bean
//	SimpleMessageListenerContainer orderingSmsListenerContainer(ConnectionFactory connectionFactory,
//			@Qualifier("orderingSmsListenerAdapter") MessageListenerAdapter orderingSmsListenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(getApplicationConfig().getOrderingSmsQueue());
//		container.setMessageListener(orderingSmsListenerAdapter);
//		return container;
//	}
//	
//	@Bean(name="orderingSmsListenerAdapter")
//	MessageListenerAdapter orderingSmsListenerAdapter(MessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessageForOrderingSms");
//	}
//	
//	@Bean
//	SimpleMessageListenerContainer orderingTwitterListenerContainer(ConnectionFactory connectionFactory,
//			@Qualifier("orderingTwitterListenerAdapter") MessageListenerAdapter orderingTwitterListenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(getApplicationConfig().getOrderingTwitterQueue());
//		container.setMessageListener(orderingTwitterListenerAdapter);
//		return container;
//	}
//	
//	@Bean(name="orderingTwitterListenerAdapter")
//	MessageListenerAdapter orderingTwitterListenerAdapter(MessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessageForOrderingTwitter");
//	}
//	
//	@Bean
//	SimpleMessageListenerContainer ticketingEmailListenerContainer(ConnectionFactory connectionFactory,
//			@Qualifier("ticketingEmailListenerAdapter") MessageListenerAdapter ticketingEmailListenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(getApplicationConfig().getTicketingEmailQueue());
//		container.setMessageListener(ticketingEmailListenerAdapter);
//		return container;
//	}
//	
//	@Bean(name="ticketingEmailListenerAdapter")
//	MessageListenerAdapter ticketingEmailListenerAdapter(MessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessageForTicketingEmail");
//	}
//	
//	@Bean
//	SimpleMessageListenerContainer ticketingSmsListenerContainer(ConnectionFactory connectionFactory,
//			@Qualifier("ticketingSmsListenerAdapter") MessageListenerAdapter ticketingSmsListenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(getApplicationConfig().getTicketingSmsQueue());
//		container.setMessageListener(ticketingSmsListenerAdapter);
//		return container;
//	}
//	
//	@Bean(name="ticketingSmsListenerAdapter")
//	MessageListenerAdapter ticketingSmsListenerAdapter(MessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessageForTicketingSms");
//	}
//	
//	@Bean
//	SimpleMessageListenerContainer ticketingTwitterListenerContainer(ConnectionFactory connectionFactory,
//			@Qualifier("ticketingTwitterListenerAdapter") MessageListenerAdapter ticketingTwitterListenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(getApplicationConfig().getTicketingTwitterQueue());
//		container.setMessageListener(ticketingTwitterListenerAdapter);
//		return container;
//	}
//	
//	@Bean(name="ticketingTwitterListenerAdapter")
//	MessageListenerAdapter ticketingTwitterListenerAdapter(MessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessageForTicketingTwitter");
//	}

	/* Bean for rabbitTemplate */
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}
	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
}


