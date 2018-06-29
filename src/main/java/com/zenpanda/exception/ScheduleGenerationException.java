package com.zenpanda.exception;

public class ScheduleGenerationException extends GenericException {

    public ScheduleGenerationException() {
        super(
                (Integer)ErrorInfo.SCHEDULE_GENERATION_ERROR.get(ErrorInfo.ERROR_CODE_KEY),
                (String)ErrorInfo.SCHEDULE_GENERATION_ERROR.get(ErrorInfo.ERROR_MESSAGE_KEY)
        );
    }
}