package com.example.garden.service;

public class ApiException extends Exception {

    public ApiException(String message) {
        super(message);
    }

    public static class PlantNotFoundException extends ApiException {
        public PlantNotFoundException(String message) {
            super(message);
        }
    }

}

