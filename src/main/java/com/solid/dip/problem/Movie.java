package com.solid.dip.problem;

public class Movie {

    private String name;
    private DramaCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DramaCategory getCategory() {
        return new DramaCategory();
    }

    public void setCategory(DramaCategory category) {
        this.category = category;
    }
}
