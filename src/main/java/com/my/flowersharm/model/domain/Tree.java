package com.my.flowersharm.model.domain;

public class Tree extends BasePlant {
    private Size size;

    public Tree() {
    }

    public Tree(String name, Size size) {
        super(name);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
