package com.codewithrowan;

public class MortgageCalculator {
    private final static byte MONTH_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public  double calculateBalance(short numberOfPaymentsMade){
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        double balance = principal
                * ((Math.pow(1 + monthlyInterest,numberOfPayments) - Math.pow(1 + monthlyInterest ,numberOfPaymentsMade))
                /(Math.pow(1 + monthlyInterest, numberOfPayments) -1));

        return balance;
    }

    public  double calculateMortgage(){
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();
        double mortgage = principal
                * ( monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments)
                /(Math.pow(1 + monthlyInterest,numberOfPayments)-1));
        return mortgage;
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length ; month++)
            balances[month-1] = calculateBalance(month); //bec we are starting from 1

        return balances;
    }
    private float getMonthlyInterest() { //a method
        float monthlyInterest = annualInterest/ PERCENT/ MONTH_IN_YEAR;
        return monthlyInterest;
    }

    private short getNumberOfPayments() { // a method
        short numberOfPayments = (short) (years * MONTH_IN_YEAR);
        return numberOfPayments;
    }

}