package com.company;

import com.company.business.Task.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectGenerator {

    public List<Project> generate(int numberOfTechnology) {
        List<Project> projectList = generateProjectsList();

        return generateRandomProjects(projectList, numberOfTechnology);
    }

    private List<Project> generateRandomProjects(List<Project> allProjects, int numberOfTechnology) {
        List<Project> listOfRandomProjects = new ArrayList<>();

        Random r = new Random();
        int numberOfProjects = r.ints(1, 1, numberOfTechnology + 1).findFirst().getAsInt();
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
                "2020-04-02", 1500.0, 3000.0));
        projectList.add(new Project("FaceBook",
                "2020-04-02", 3000.0, 6000.0));
        projectList.add(new Project("SnapChat",
                "2020-04-02", 2000.0, 4000.0));
        projectList.add(new Project("Uber",
                "2020-04-02", 1000.0, 2000.0));
        projectList.add(new Project("Instagram",
                "2020-04-02", 3000.0, 6000.0));
        projectList.add(new Project("Messenger",
                "2020-04-02", 1500.0, 3000.0));
        projectList.add(new Project("Glovo",
                "2020-04-02", 500.0, 1000.0));
        projectList.add(new Project("YouTube",
                "2020-04-02", 3500.0, 7000.0));
        projectList.add(new Project("Netflix",
                "2020-04-02", 4000.0, 8000.0));
        projectList.add(new Project("HBO GO",
                "2020-04-02", 3000.0, 6000.0));
        projectList.add(new Project("Gmail",
                "2020-04-02", 2000.0, 4000.0));
        projectList.add(new Project("Udemy",
                "2020-04-02", 2500.0, 5000.0));
        projectList.add(new Project("Spotify",
                "2020-04-02", 3500.0, 7000.0));

        return projectList;
    }
}
