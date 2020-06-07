package com.company.People;

public abstract class Human {
    private final String name;
    private final String surname;
    private Double money;
    private String email;

    public Human(String name, String surname, Double money, String email) {
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.email = email;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


}
