package com.company.business.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectGenerator {

    public List<Project> generate(int numberOfProjects) {
        List<Project> projectList = generateProjectsList();

        return generateRandomProjects(projectList, numberOfProjects);
    }

    private List<Project> generateRandomProjects(List<Project> allProjects, int numberOfProjects) {
        List<Project> listOfRandomProjects = new ArrayList<>();

        Random r = new Random();
        //int numberOfProjects = r.ints(1, 1, numberOfProject + 1).findFirst().getAsInt();
        for (int i = 0; i < numberOfProjects; i++) {
            int indexOfProject = r.ints(1, 0, allProjects.size()).findFirst().getAsInt();

            if (!listOfRandomProjects.contains(allProjects.get(indexOfProject))) {
                listOfRandomProjects.add(allProjects.get(indexOfProject));
            }
        }
        return listOfRandomProjects;
    }

    private List<Project> generateProjectsList() {
        List<Project> projectList = new ArrayList<>();

        projectList.add(new Project("Tinder",
                1500.0, 3000.0, LocalDate.of(2020, 01, 17)));
        projectList.add(new Project("FaceBook",
                3000.0, 6000.0, LocalDate.of(2020, 01, 18)));
        projectList.add(new Project("SnapChat",
                2000.0, 4000.0, LocalDate.of(2020, 01, 19)));
        projectList.add(new Project("Uber",
                1000.0, 2000.0, LocalDate.of(2020, 01, 17)));
        projectList.add(new Project("Instagram",
                3000.0, 6000.0, LocalDate.of(2020, 01, 19)));
        projectList.add(new Project("Messenger",
                1500.0, 3000.0, LocalDate.of(2020, 01, 19)));
        projectList.add(new Project("Glovo",
                500.0, 1000.0, LocalDate.of(2020, 01, 18)));
        projectList.add(new Project("YouTube",
                3500.0, 7000.0, LocalDate.of(2020, 01, 16)));
        projectList.add(new Project("Netflix",
                4000.0, 8000.0, LocalDate.of(2020, 01, 17)));
        projectList.add(new Project("HBO GO",
                3000.0, 6000.0, LocalDate.of(2020, 01, 17)));
        projectList.add(new Project("Gmail",
                2000.0, 4000.0, LocalDate.of(2020, 01, 16)));
        projectList.add(new Project("Udemy",
                2500.0, 5000.0, LocalDate.of(2020, 01, 16)));
        projectList.add(new Project("Spotify",
                3500.0, 7000.0, LocalDate.of(2020, 01, 17)));

        return projectList;
    }
}
