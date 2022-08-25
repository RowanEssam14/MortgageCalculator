package com.codewithrowan;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private  MortgageCalculator calculator;//declared an object

    public MortgageReport(MortgageCalculator calculator) { //has a calculator parameter of type ..
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for(double balance: calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(calculator.calculateMortgage());

        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly payments: " + mortgageFormatted);
    }
}