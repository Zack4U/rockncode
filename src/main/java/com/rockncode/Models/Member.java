package com.rockncode.Models;

public class Member {
    private String name;
    private String instrument;
    private String skill;

    public Member(String name, String instrument, String skill) {
        this.name = name;
        this.instrument = instrument;
        this.skill = skill;
    }

    /**
     * Getters and Setters
     */
    public String getInstrument() {
        return instrument;
    }

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * Custom Methods
     */
}
