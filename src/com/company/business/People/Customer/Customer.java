package com.company.business.People.Customer;

import com.company.business.People.Human;

public abstract class Customer extends Human {

    private Integer chanceOfLatePaymentByAWeek;
    private Integer chanceToAvoidPunishment;
    private Integer chanceOfLosingTheContract;
    private Integer chanceOfLatePaymentByAMonth;
    private Integer chanceOfNeverGetPaid;

    public Customer(String name, String surname, Double money) {
        super(name, surname, money);

    }

    public Integer getChanceOfLatePaymentByAWeek() {
        return chanceOfLatePaymentByAWeek;
    }

    public void setChanceOfLatePaymentByAWeek(Integer chanceOfLatePaymentByAWeek) {
        this.chanceOfLatePaymentByAWeek = chanceOfLatePaymentByAWeek;
    }

    public Integer getChanceToAvoidPunishment() {
        return chanceToAvoidPunishment;
    }

    public void setChanceToAvoidPunishment(Integer chanceToAvoidPunishment) {
        this.chanceToAvoidPunishment = chanceToAvoidPunishment;
    }

    public Integer getChanceOfLosingTheContract() {
        return chanceOfLosingTheContract;
    }

    public void setChanceOfLosingTheContract(Integer chanceOfLosingTheContract) {
        this.chanceOfLosingTheContract = chanceOfLosingTheContract;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }

    public Integer getChanceOfLatePaymentByAMonth() {
        return chanceOfLatePaymentByAMonth;
    }

    public void setChanceOfLatePaymentByAMonth(Integer chanceOfLatePaymentByAMonth) {
        this.chanceOfLatePaymentByAMonth = chanceOfLatePaymentByAMonth;
    }

    public Integer getChanceOfNeverGetPaid() {
        return chanceOfNeverGetPaid;
    }

    public void setChanceOfNeverGetPaid(Integer chanceOfNeverGetPaid) {
        this.chanceOfNeverGetPaid = chanceOfNeverGetPaid;
    }
}
