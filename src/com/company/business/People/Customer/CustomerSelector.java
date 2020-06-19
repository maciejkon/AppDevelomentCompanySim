package com.company.business.People.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerSelector {
    private List<Customer> listOFCustomers = new ArrayList<>();

    public CustomerSelector() {
        this.listOFCustomers.add(new HighClassCustomer("Andrzej", "Ciesz1yński", 1000000.0));
        this.listOFCustomers.add(new MiddleClassCustomer("Jan", "Kowalski", 200000.0));
        this.listOFCustomers.add(new LowClassCustomer("Zbigniew", "Kulesza", 50000.0));
    }

    public Customer select() {
        Random r = new Random();
        int numberOfCustomers = r.ints(1, 0, 3).findFirst().getAsInt();

        return listOFCustomers.get(numberOfCustomers);
    }
}
