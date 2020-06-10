package com.company.business.People.Customer;

import com.company.business.People.Human;

public abstract class Customer extends Human {

    private Double chanceOfLatePaymentByAWeek;
    private Double chanceToAvoidPunishment;
    private Double chanceOfLosingTheContract;

    public Customer(String name, String surname, Double money, String email) {
        super(name, surname, money, email);

    }

    public Double getChanceOfLatePaymentByAWeek() {
        return chanceOfLatePaymentByAWeek;
    }

    public void setChanceOfLatePaymentByAWeek(Double chanceOfLatePaymentByAWeek) {
        this.chanceOfLatePaymentByAWeek = chanceOfLatePaymentByAWeek;
    }

    public Double getChanceToAvoidPunishment() {
        return chanceToAvoidPunishment;
    }

    public void setChanceToAvoidPunishment(Double chanceToAvoidPunishment) {
        this.chanceToAvoidPunishment = chanceToAvoidPunishment;
    }

    public Double getChanceOfLosingTheContract() {
        return chanceOfLosingTheContract;
    }

    public void setChanceOfLosingTheContract(Double chanceOfLosingTheContract) {
        this.chanceOfLosingTheContract = chanceOfLosingTheContract;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getEmail();
    }
}
