package com.zenpanda.exception;

public class InvalidShiftDurationException extends GenericException {

    public InvalidShiftDurationException() {
        super(
                (Integer)ErrorInfo.INVALID_SHIFT_DURATION.get(ErrorInfo.ERROR_CODE_KEY),
                (String)ErrorInfo.INVALID_SHIFT_DURATION.get(ErrorInfo.ERROR_MESSAGE_KEY)
        );
    }
}
