package com.exceptionHlanding;

public class BalanceDepositor {
    private ErrorListener errorListener;
    public BalanceDepositor(){
        this.errorListener = new ErrorHandler();
    }
    public void deposit(double amount){
        try{
            if(amount<0){
                throw new BalanceException("Invalid deposit amount. Please enter a positive value.");
            }else if(amount>1000){
                throw new BalanceExceedLimitException("Amount is exceeding limit. Please enter amount less than 1000");
            }
            System.out.println("Deposited successfully: "+amount);
        }catch(BalanceException e){
            errorListener.onError(e);
        } catch (BalanceExceedLimitException e) {
            errorListener.onError(e);
        }
    }
}
