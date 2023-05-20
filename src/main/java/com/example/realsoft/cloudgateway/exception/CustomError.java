package com.example.realsoft.cloudgateway.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
@Setter
public class CustomError {
    private final String message;
    private final String code;
    private final int status;
    private final long timestamp;

    public CustomError(String message, String code, int status) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.timestamp = Instant.now().toEpochMilli();
    }
}
