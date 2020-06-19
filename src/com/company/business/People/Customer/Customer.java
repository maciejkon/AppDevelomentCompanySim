package com.company.business.People.Customer;

import com.company.business.People.Human;

public class Customer extends Human {

    private Integer chanceOfLatePaymentByAWeek;
    private Integer chanceToAvoidPunishment;
    private Integer chanceOfLosingTheContract;
    private Integer chanceOfLatePaymentByAMonth;
    private Integer chanceOfNeverGetPaid;
    private CustomerClass customerClass;

    public Customer(String name, String surname, Double money, CustomerClass customerClass) {
        super(name, surname, money);

        switch (customerClass) {
            case LOW:
                this.chanceOfLatePaymentByAWeek = 30;
                this.chanceToAvoidPunishment = 0;
                this.chanceOfLosingTheContract = 100;
                this.chanceOfLatePaymentByAMonth = 5;
                this.chanceOfNeverGetPaid = 1;
                break;
            case MIDDLE:
                this.chanceOfLatePaymentByAWeek = 30;
                this.chanceToAvoidPunishment = 20;
                this.chanceOfLosingTheContract = 0;
                this.chanceOfLatePaymentByAMonth = 0;
                this.chanceOfNeverGetPaid = 0;
                break;
            case HIGH:
                this.chanceOfLatePaymentByAWeek = 0;
                this.chanceToAvoidPunishment = 0;
                this.chanceOfLosingTheContract = 50;
                this.chanceOfLatePaymentByAMonth = 0;
                this.chanceOfNeverGetPaid = 0;
                break;
        }

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
