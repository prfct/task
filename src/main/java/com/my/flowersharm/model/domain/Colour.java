package com.my.flowersharm.model.domain;

public enum  Colour {
    BLUE("BLUE"), WHITE("WHITE"), YELLOW("YELLOW"), RED("RED"), BLACK("BLACK"), PURPLE("PURPLE");

    private String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}
