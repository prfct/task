package com.my.flowersharm.model.domain;

/**
 * @author Oleksii Petrokhalko.
 */
public enum Size {
    LITTLE("little"), AVERAGE("average"), BIG("big"), HUGE("huge");

    private String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
