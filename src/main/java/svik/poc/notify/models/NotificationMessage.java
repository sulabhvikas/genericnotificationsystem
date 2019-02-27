package svik.poc.notify.models;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class NotificationMessage {
	
	/**
	 * unique identifier = applicationId+timestamp e.g. DemoOrderingApp_2019-24-27T16:30:00+00:00_1
	 */
	@ApiModelProperty(notes = "unique identifier from client applicationId+timestamp e.g. DemoOrderingApp_2019-24-27T16:30:00+00:00_1", required =true)
	private String correlationId;
	
	/**
	 * 
	 */
	@ApiModelProperty(notes = "notification to be sent to", required =true)
	private String to;
	
	/**
	 * notification sent from/by
	 */
	@ApiModelProperty(notes = "notification sent from/by", required =true)
	private String from;

	@ApiModelProperty(notes = "notification channels e.g. sms, email, twitter", required =true)
	private Channel channel;
	
	/**
	 * if templateId == null then no template available
	 */
	@ApiModelProperty(notes = "Unique Template ID for notifications which have specific message templates", required =false)
	private String templateId;
	
	@ApiModelProperty(notes = "notification message", required =true)
	private String text;
	
	/**
	 * customer's account id
	 */
	@ApiModelProperty(notes = "customer account id", required =true)
	private String accountId;
	
	/**
	 * Customer First Name
	 */
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "firstName is invalid !")
	@ApiModelProperty(notes = "first name of customer to be notified", required =false)
	private String firstName;

	/**
	 * Customer Last Name
	 */
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "lastName is invalid !")
	@ApiModelProperty(notes = "last name of customer to be notified", required =false)
	private String lastName;
	
	@ApiModelProperty(notes = "client application id", required =false)
	private String applicationId;
	
	@ApiModelProperty(notes = "notification date", required =false)
	private Date date;

	@Override
	public String toString() {
		return "NotificationMessage [correlationId=" + correlationId + ", to=" + to + ", from=" + from + ", channel="
				+ channel + ", templateId=" + templateId + ", text=" + text + ", accountId=" + accountId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", applicationId=" + applicationId + ", date="
				+ date + "]";
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * Channel of communication for the message. SMS, email, twitter
	 */
	public enum Channel {
		sms, email, twitter
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
