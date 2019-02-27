# Generic Notification System

Centralized generic service for notification that can be used by a variety consuming application for their notification needs e.g. an incident workflow system may use this system when each incident ticket moves from one state to another, similarly a order management system may use this service to notify the customer of the status of the order whenever it changes

## Getting Started

To install this application, run the following commands:

```
git clone https://github.com/sulabhvikas/genericnotificationsystem.git
cd genericnotificationsystem
```

This application uses RabbitMq to send messages to dedicated channels. To install RabbitMq, run the following commands:

brew install rabbitmq

### Prerequisites
1. spring boot
2. rabbitmq
3. Maven
4. curl

## Installations

application.properties

```
X-AUTH_TOKEN= < Not implemented >
authorized.applications=Ordering,Ticketing

# Message Queue specific configs for ordering
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
#AMQP RabbitMQ configuration 
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
# Additional RabbitMQ properties
spring.rabbitmq.listener.simple.concurrency=4
spring.rabbitmq.listener.simple.max-concurrency=8
spring.rabbitmq.listener.simple.retry.initial-interval=5000
```

Install RabbitMq

```
brew install rabbitmq
```

### Start the servers

```
brew services start rabbitmq
```

Starts the RabbitMq server at http://localhost:15672/

```
mvn install
java -jar target/GenericNotificationSystem-0.0.1-SNAPSHOT.jar
```

Starts the Spring Boot application at http://localhost:8080/notifications/api/v1/send
Swagger UI at http://localhost:8080/notifications/swagger-ui.html 

Run application for email notifications from Ordering application

```
curl -d "@data/ordering-email-sample.json" -H "Content-Type: application/json" -X POST http://localhost:8080/notifications/api/v1/send
```

Open another terminal for curl commands

```
cd genericnotificationsystem
```

Run application for sms notifications from Ordering application

```
curl -d "@data/ordering-sms-sample.json" -H "Content-Type: application/json" -X POST http://localhost:8080/notifications/api/v1/send
```

Run application for email notifications from Ticketing application

```
curl -d "@data/ordering-sms-sample.json" -H "Content-Type: application/json" -X POST http://localhost:8080/notifications/api/v1/send
```

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Authors

* **Sulabh Vikas** - *GitHub* - [SulabhVikas](https://github.com/sulabhvikas)
