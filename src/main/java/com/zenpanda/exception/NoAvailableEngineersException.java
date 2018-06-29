package com.zenpanda.exception;

public class NoAvailableEngineersException extends GenericException {

    public NoAvailableEngineersException() {
        super(
                (Integer)ErrorInfo.NO_AVAILABLE_ENGINEERS.get(ErrorInfo.ERROR_CODE_KEY),
                (String)ErrorInfo.NO_AVAILABLE_ENGINEERS.get(ErrorInfo.ERROR_MESSAGE_KEY)
        );
    }
}
