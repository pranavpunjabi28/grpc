package com.demo.grpc.exceptions;

public class ServerException extends RuntimeException {
    public ServerException(String message) {
        super(message);
    }
}
