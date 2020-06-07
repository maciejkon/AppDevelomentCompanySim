package com.company.Task;

import com.company.People.Customer.Customer;
import com.company.People.Worker.Worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private  String titleOfProject;
    private Customer client;
    private Date deadLine;
    private Double amountOfPenalty;
    private Double priceOfProject;
    private List<Worker> WorkersOnProject = new ArrayList<>();
    private Boolean payOnAdvance;

    public Project(String titleOfProject,Customer client,Date deadLine,Double amountOfPenalty,
                   Double priceOfProject,Boolean payOnAdvance){

        this.titleOfProject=titleOfProject;
        this.client=client;
        this.deadLine=deadLine;
        this.amountOfPenalty=amountOfPenalty;
        this.priceOfProject=priceOfProject;
        this.payOnAdvance=payOnAdvance;
    }
}
