package com.company.business.People.Customer;

public class LowClassCustomer extends Customer {

    private Double chanceOfLatePaymentByAMonth;
    private Double chanceOfNeverGetPaid;

    static final public Double DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_WEEK = 0.3;
    static final public Double DEFAULT_CHANCE_TO_AVOID_PUNISHMENT = 0.0;
    static final public Double DEFAULT_CHANCE_OF_LOSING_CONTRACT = 1.0;

    public LowClassCustomer(String name, String surname, Double money, String email) {
        super(name, surname, money, email);

        super.setChanceOfLatePaymentByAWeek(DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_WEEK);
        super.setChanceToAvoidPunishment(DEFAULT_CHANCE_TO_AVOID_PUNISHMENT);
        super.setChanceOfLosingTheContract(DEFAULT_CHANCE_OF_LOSING_CONTRACT);

        this.chanceOfLatePaymentByAMonth = 0.05;
        this.chanceOfNeverGetPaid = 0.01;


    }


    public Double getChanceOfLatePaymentByAMonth() {
        return chanceOfLatePaymentByAMonth;
    }

    public Double getChanceOfNeverGetPaid() {
        return chanceOfNeverGetPaid;
    }
}
