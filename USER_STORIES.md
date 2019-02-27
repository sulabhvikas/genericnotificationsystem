# Generic Notification System

### User Story 1

Name: Send Notification

Description: As a user, applications should be able to send notifications to customers through different channels of preference

Acceptance Criteria:
 - Validate Message body for mandatory and optional fields
 - Validate correlationId format e.g. <ClientAppName_datetimestamp_sequence>
 - Validate to and from fields based on channel preference 
 	i.e. if channel is email then to and from should be valid email ids
 		 if channel is sms then to and from should be valid phone numbers
 - Validate valid templateId is present if subject not provided; otherwise optional
 - Generate success and failure HTTP Status code after processing send operation

### User Story 2

Name: Deliver order of messages

Description: As a user, my messages should be delivered to the customer in the order it was sent.

Acceptance Criteria:
 - Validate order of the messages 
 - Validate the messages sent on delicated queue


### User Story 3

Name: Authentication and Authorization of calling application

Description: As a user, applications should be able to send notifications tonly if they can authenticate themselves against the service AND if they are authorized

Acceptance Criteria:
 - Validate auth token
 - Validate authorization; send failure response if application not authorized
 - Generate success and failure HTTP Status code after processing send operation
