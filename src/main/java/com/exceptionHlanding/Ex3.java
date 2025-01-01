package com.exceptionHlanding;

public class Ex3 {
    public static void main(String[] args) {
       ErrorHandler errorHandler = new ErrorHandler();
       BalanceDepositor balanceDepositor = new BalanceDepositor();
       balanceDepositor.deposit(30000000);
       balanceDepositor.deposit(-30000000);
    }
}
