package com.company;

import com.company.business.Task.Technology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TechnologyGenerator {

    public List<Technology> generate() {
        List<Technology> technologyList = generateTechnologyList();

        return generateRandomTechnologies(technologyList);
    }

    private List<Technology> generateRandomTechnologies(List<Technology> allTechnology) {
        List<Technology> listOfRandomTechnologies = new ArrayList<>();

        Random r = new Random();
        int numberOfTechnologies = r.ints(1, 1, 4).findFirst().getAsInt();
        for (int i = 0; i < numberOfTechnologies; i++) {
            int indexOfTechnology = r.ints(1, 0, allTechnology.size()).findFirst().getAsInt();

            if (!listOfRandomTechnologies.contains(allTechnology.get(indexOfTechnology))) {
                listOfRandomTechnologies.add(allTechnology.get(indexOfTechnology));
            }
        }
        return listOfRandomTechnologies;
    }

    private List<Technology> generateTechnologyList() {
        List<Technology> technologyList = new ArrayList<>();

        technologyList.add(new Technology("front-end", 5));
        technologyList.add(new Technology("backend", 14));
        technologyList.add(new Technology("dataBase", 4));
        technologyList.add(new Technology("mobile", 7));
        technologyList.add(new Technology("WordPress", 4));
        technologyList.add(new Technology("PrestaShop", 4));

        return technologyList;
    }


}
