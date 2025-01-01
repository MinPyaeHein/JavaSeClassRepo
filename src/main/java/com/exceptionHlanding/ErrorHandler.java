package com.exceptionHlanding;

public class ErrorHandler implements ErrorListener {
    @Override
    public void onError(Exception e) {
        System.err.println("An error occurred: " + e.getMessage());
    }
}
