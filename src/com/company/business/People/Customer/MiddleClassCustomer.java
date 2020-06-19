package com.company.business.People.Customer;

public class MiddleClassCustomer extends Customer {

    static final public Integer DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_WEEK_IN_PERCENT = 30;
    static final public Integer DEFAULT_CHANCE_TO_AVOID_PUNISHMENT_IN_PERCENT = 20;
    static final public Integer DEFAULT_CHANCE_OF_LOSING_CONTRACT_IN_PERCENT = 0;
    static final public Integer DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_MONTH_IN_PERCENT = 0;
    static final public Integer DEFAULT_CHANCE_TO_NEVER_GET_PAID_IN_PERCENT = 0;

    public MiddleClassCustomer(String name, String surname, Double money) {
        super(name, surname, money);

        super.setChanceOfLatePaymentByAWeek(DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_WEEK_IN_PERCENT);
        super.setChanceToAvoidPunishment(DEFAULT_CHANCE_TO_AVOID_PUNISHMENT_IN_PERCENT);
        super.setChanceOfLosingTheContract(DEFAULT_CHANCE_OF_LOSING_CONTRACT_IN_PERCENT);
        super.setChanceOfLatePaymentByAMonth(DEFAULT_CHANCE_OF_LATE_PAYMENT_BY_A_MONTH_IN_PERCENT);
        super.setChanceOfNeverGetPaid(DEFAULT_CHANCE_TO_NEVER_GET_PAID_IN_PERCENT);

    }
}
