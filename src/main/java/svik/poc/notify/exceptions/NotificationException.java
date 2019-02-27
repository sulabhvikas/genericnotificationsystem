package svik.poc.notify.exceptions;

public class NotificationException extends Exception {
	
	public static final String BAD_REQUEST = "Notification_Bad_Request";
	
	public NotificationException() { 
        // Call constructor of parent Exception 
        super(); 
    } 
	
	public NotificationException(String s) { 
        // Call constructor of parent Exception 
        super(s); 
    } 	
	
	//public NotificationException(String s, String message) { 
        // Call constructor of parent Exception 
    //    super(s, message); 
    //} 

}
