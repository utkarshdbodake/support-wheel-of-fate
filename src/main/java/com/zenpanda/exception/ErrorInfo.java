package com.zenpanda.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorInfo{

    public final static String ERROR_CODE_KEY = "errorCode";
    public final static String ERROR_MESSAGE_KEY = "errorMessage";

    public final static Map INVALID_SHIFT_DURATION = new HashMap<String, Object>() {{
        put(ERROR_CODE_KEY, 9001);
        put(ERROR_MESSAGE_KEY, "Shift duration cannot be greater than 24 hours!");
    }};

    public final static Map NO_AVAILABLE_ENGINEERS = new HashMap<String, Object>() {{
        put(ERROR_CODE_KEY, 9002);
        put(ERROR_MESSAGE_KEY, "No available engineers found!");
    }};

    public final static Map SCHEDULE_GENERATION_ERROR = new HashMap<String, Object>() {{
        put(ERROR_CODE_KEY, 9003);
        put(ERROR_MESSAGE_KEY, "Something went wrong while generating the schedule.");
    }};
}
