package com.company.People.Customer;

public class HighClassCustomer extends Customer {



    static final public Double DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_WEEK = 0.0;
    static final public Double DEFAULT_CHANCE_TO_AVOID_PUNISHMENT = 0.0;
    static final public Double DEFAULT_CHANCE_OF_LOSING_CONTRACT = 0.5;


    public HighClassCustomer(String name, String surname, Double money, String email) {
        super(name, surname, money, email);
        super.setChanceOfLatePaymentByAWeek(DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_WEEK);
        super.setChanceToAvoidPunishment(DEFAULT_CHANCE_TO_AVOID_PUNISHMENT);
        super.setChanceOfLosingTheContract(DEFAULT_CHANCE_OF_LOSING_CONTRACT);
    }


}
