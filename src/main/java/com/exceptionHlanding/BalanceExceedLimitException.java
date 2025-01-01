package com.exceptionHlanding;

public class BalanceExceedLimitException extends Exception{
    public BalanceExceedLimitException(String message){
        super(message);
    }

}
