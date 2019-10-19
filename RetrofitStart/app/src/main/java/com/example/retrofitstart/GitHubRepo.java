package com.example.retrofitstart;

public class GitHubRepo {
    private int id;
    private String name;

    public GitHubRepo() {
    }

    public GitHubRepo(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
