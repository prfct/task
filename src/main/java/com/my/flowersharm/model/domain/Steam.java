package com.my.flowersharm.model.domain;

/**
 * @author Oleksii Petrokhalko.
 */
public enum  Steam {
    WITHOUT("WITHOUT"), SHORT("SHORT"), MIDDLE("MIDDLE"), LONG("LONG");

    private String size;

    Steam(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
