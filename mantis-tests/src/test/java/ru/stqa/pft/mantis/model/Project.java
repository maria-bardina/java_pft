package ru.stqa.pft.mantis.model;

/**
 * Created by bardina_md on 12.09.17.
 */
public class Project {

    private int id;

    public int getId() {
        return id;
    }

    public Project withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project withName(String name) {
        this.name = name;
        return this;
    }

    private String name;
}
