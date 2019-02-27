package svik.poc.notify.channels;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.messaging.MessagingException;

import svik.poc.notify.models.NotificationMessage;

public abstract class Channel  {
	
	public abstract boolean sendMessage(NotificationMessage message) throws MessagingException, IOException;
	
}
