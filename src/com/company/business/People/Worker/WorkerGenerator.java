package com.company.business.People.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerGenerator {
    public List<Worker> generate() {
        List<Worker> workersList = generateWorkerList();

        return generateRandomWorkers(workersList);
    }

    private List<Worker> generateRandomWorkers(List<Worker> allWorkers) {
        List<Worker> listOfRandomWorkers = new ArrayList<>();

        Random r = new Random();
        int numberOfWorkers = r.ints(1, 3, 7).findFirst().getAsInt();
        for (int i = 0; i < numberOfWorkers; i++) {
            int indexOfTechnology = r.ints(1, 0, allWorkers.size()).findFirst().getAsInt();

            if (!listOfRandomWorkers.contains(allWorkers.get(indexOfTechnology))) {
                listOfRandomWorkers.add(allWorkers.get(indexOfTechnology));
            }
        }
        return listOfRandomWorkers;
    }

    private List<Worker> generateWorkerList() {
        List<Worker> workersList = new ArrayList<>();

        workersList.add(new Programmer("Maciej", "Weltrowski", 1000.0));
        workersList.add(new Programmer("Rafał", "Zakrzewski", 10000.0));
        workersList.add(new Programmer("Jan", "Kowalski", 500.0));
        workersList.add(new Programmer("Mieszko ", "Tomaszewski", 2000.0));
        workersList.add(new Programmer("Artur ", "Kaźmierczak", 2500.0));
        workersList.add(new Programmer("Józef", "Maciejewski", 3000.0));
        workersList.add(new Programmer("Aleks ", "Makowski", 1500.0));
        workersList.add(new Programmer("Aureliusz ", "Kubiak", 500.0));
        workersList.add(new Seller("Hubert", "Witkowski", 500.0));
        workersList.add(new Tester("Miron", "Kwiatkowski", 500.0));
        workersList.add(new Seller("Konstanty", "Lis", 500.0));


        return workersList;
    }
}
