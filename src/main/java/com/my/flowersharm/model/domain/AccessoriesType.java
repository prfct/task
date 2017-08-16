package com.my.flowersharm.model.domain;

public enum  AccessoriesType {
    BUCKET("bucket"), RIBBON("ribbon"), RAINBOW("rainbow");

    private String type;

    AccessoriesType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
