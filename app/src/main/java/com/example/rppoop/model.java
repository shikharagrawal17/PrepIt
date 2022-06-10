package com.example.rppoop;

public class model {

    String name, logo, placements, averageSalary, rounds;

    public model() {
    }

    public model(String name, String logo, String placements, String averageSalary, String rounds) {
        this.name = name;
        this.logo = logo;
        this.placements = placements;
        this.averageSalary = averageSalary;
        this.rounds = rounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPlacements() {
        return placements;
    }

    public void setPlacements(String placements) {
        this.placements = placements;
    }

    public String getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(String averageSalary) {
        this.averageSalary = averageSalary;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }
}
