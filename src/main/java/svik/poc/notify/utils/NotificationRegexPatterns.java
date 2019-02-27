package svik.poc.notify.utils;

import java.util.regex.Pattern;

public class NotificationRegexPatterns {
	
    public static final Pattern PHONE_REGEX = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
    public static final Pattern EMAIL_ADDRESS
    = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
        "\\@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
        ")+"
    );
	public static final String REGEX_EMAIL = "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)";
	public static final String REGEX_PHONE = "^(?=(?:\\D*\\d){10,11}\\D*$)\\+?[0-9]{1,3}[\\s-]?(?:\\(0?[0-9]{1,5}\\)|[0-9]{1,5})[-\\s]?[0-9][\\d\\s-]{5,7}\\s?(?:x[\\d-]{0,4})?$";

	private NotificationRegexPatterns() {
	}

}
