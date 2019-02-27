package svik.poc.notify;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import svik.poc.notify.queue.ApplicationConfigReader;

//@EnableRabbit
@SpringBootApplication
public class GenericNotificationSystemApplication {
//public class GenericNotificationSystemApplication extends SpringBootServletInitializer implements RabbitListenerConfigurer {

//	@Autowired
//	private ApplicationConfigReader applicationConfig;
//	
//	public ApplicationConfigReader getApplicationConfig() {
//		return applicationConfig;
//	}
//	public void setApplicationConfig(ApplicationConfigReader applicationConfig) {
//		this.applicationConfig = applicationConfig;
//	}

	
	public static void main(String[] args) {
		SpringApplication.run(GenericNotificationSystemApplication.class, args);
	}
//	
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(GenericNotificationSystemApplication.class);
//	}
//	
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        return new RabbitAdmin(connectionFactory);
//    }
//	
//	/* This bean is to read the properties file configs */
//	@Bean
//	public ApplicationConfigReader applicationConfig() {
//		return new ApplicationConfigReader();
//	}
//	
//	/* Creating a bean for the Message queue Exchange - Ordering*/
//	@Bean
//	public TopicExchange getOrderingExchange() {
//		return new TopicExchange(getApplicationConfig().getOrderingExchange());
//	}
//	
//
//	/* Creating a bean for the Message queue - Ordering - Email*/
//	@Bean
//	public Queue getOrderingEmailQueue() {
//		return new Queue(getApplicationConfig().getOrderingEmailQueue());
//	}
//	
//	/* Binding between Exchange and Queue using routing key - Ordering - Email */
//	@Bean
//	public Binding declareBindingOrderingEmail() {
//		return BindingBuilder.bind(getOrderingEmailQueue()).to(getOrderingExchange()).with(getApplicationConfig().getOrderingEmailRoutingKey());
//	}
//	
//	/* Creating a bean for the Message queue - Ordering - SMS*/
//	@Bean
//	public Queue getOrderingSmsQueue() {
//		return new Queue(getApplicationConfig().getOrderingSmsQueue());
//	}
//	
//	/* Binding between Exchange and Queue using routing key - Ordering - SMS */
//	@Bean
//	public Binding declareBindingOrderingSms() {
//		return BindingBuilder.bind(getOrderingSmsQueue()).to(getOrderingExchange()).with(getApplicationConfig().getOrderingSmsRoutingKey());
//	}
//	
//	/* Creating a bean for the Message queue - Ordering - Twitter*/
//	@Bean
//	public Queue getOrderingTwitterQueue() {
//		return new Queue(getApplicationConfig().getOrderingTwitterQueue());
//	}
//	
//	/* Binding between Exchange and Queue using routing key - Ordering - Twitter */
//	@Bean
//	public Binding declareBindingOrderingTwitter() {
//		return BindingBuilder.bind(getOrderingTwitterQueue()).to(getOrderingExchange()).with(getApplicationConfig().getOrderingTwitterRoutingKey());
//	}
//
//	/* Creating a bean for the Message queue Exchange - Ticketing*/
//	@Bean
//	public TopicExchange getTicketingExchange() {
//		return new TopicExchange(getApplicationConfig().getTicketingExchange());
//	}
//	
//	/* Creating a bean for the Message queue - Ticketing - Email*/
//	@Bean
//	public Queue getTicketingEmailQueue() {
//		return new Queue(getApplicationConfig().getTicketingEmailQueue());
//	}
//	
//	/* Binding between Exchange and Queue using routing key - Ticketing - Email */
//	@Bean
//	public Binding declareBindingTicketingEmail() {
//		return BindingBuilder.bind(getTicketingEmailQueue()).to(getTicketingExchange()).with(getApplicationConfig().getTicketingEmailRoutingKey());
//	}
//	
//	/* Creating a bean for the Message queue - Ticketing - SMS*/
//	@Bean
//	public Queue getTicketingSmsQueue() {
//		return new Queue(getApplicationConfig().getTicketingSmsQueue());
//	}
//	
//	/* Binding between Exchange and Queue using routing key - Ticketing - SMS */
//	@Bean
//	public Binding declareBindingTicketingSms() {
//		return BindingBuilder.bind(getTicketingSmsQueue()).to(getTicketingExchange()).with(getApplicationConfig().getTicketingSmsRoutingKey());
//	}
//	
//	/* Creating a bean for the Message queue - Ticketing - Twitter*/
//	@Bean
//	public Queue getTicketingTwitterQueue() {
//		return new Queue(getApplicationConfig().getTicketingTwitterQueue());
//	}
//	
//	/* Binding between Exchange and Queue using routing key - Ticketing - Twitter */
//	@Bean
//	public Binding declareBindingTicketingTwitter() {
//		return BindingBuilder.bind(getTicketingTwitterQueue()).to(getTicketingExchange()).with(getApplicationConfig().getTicketingTwitterRoutingKey());
//	}
//	
//	/* Bean for rabbitTemplate */
//	@Bean
//	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//		return rabbitTemplate;
//	}
//	@Bean
//	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
//		return new Jackson2JsonMessageConverter();
//	}
//	@Bean
//	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
//		return new MappingJackson2MessageConverter();
//	}
//	@Bean
//	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
//		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
//		factory.setMessageConverter(consumerJackson2MessageConverter());
//	return factory;
//	}
//
//
//	@Override
//	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
//		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
//		
//	}

}
