package com.demo.democar.exception;

import java.awt.TrayIcon.MessageType;

/**
 * This DTO contains the information of a single validation error.
 *
 * 
 */
public class FieldValidationError {

    private String field;
    private String message;
    private MessageType type;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

}

