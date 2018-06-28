package com.zenpanda.exception;

public class NoAvailableEngineersException extends GenericException {

    public NoAvailableEngineersException() {
        super(
                (Integer)ErrorInfo.INVALID_SHIFT_DURATION.get(ErrorInfo.ERROR_CODE_KEY),
                (String)ErrorInfo.INVALID_SHIFT_DURATION.get(ErrorInfo.ERROR_MESSAGE_KEY)
        );
    }
}
