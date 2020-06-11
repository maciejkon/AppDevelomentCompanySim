package com.company.business.People;

public abstract class Human {
    private final String name;
    private final String surname;
    private Double money;


    public Human(String name, String surname, Double money) {
        this.name = name;
        this.surname = surname;
        this.money = money;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
