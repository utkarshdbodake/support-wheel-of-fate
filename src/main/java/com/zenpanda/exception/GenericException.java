package com.zenpanda.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericException extends Exception {

    private int errorCode;
    private String errorMessage;
}
