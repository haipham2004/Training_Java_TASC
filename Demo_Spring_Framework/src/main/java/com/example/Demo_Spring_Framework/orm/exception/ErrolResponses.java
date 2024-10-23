package com.example.Demo_Spring_Framework.orm.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrolResponses {

    public int status;
    public String message;
    public long timestamp;

    public ErrolResponses(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp=System.currentTimeMillis();
    }
}
