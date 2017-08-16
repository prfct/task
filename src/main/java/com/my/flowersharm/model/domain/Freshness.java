package com.my.flowersharm.model.domain;

/**
 * @author Oleksii Petrokhalko.
 */
public enum Freshness {
    VERY("VERY"), FRESH("FRESH"), BAD("BAD"), SLUGGISH("SLUGGISH");

    String type;

    Freshness(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
