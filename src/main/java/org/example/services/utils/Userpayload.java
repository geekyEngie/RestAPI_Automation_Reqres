package org.example.services.utils;

public class Userpayload {
    private String name;
    private String job;
    private int id;
    private int age;

    public Userpayload(int age, int id, String job, String name) {
        this.age = age;
        this.id = id;
        this.job = job;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
