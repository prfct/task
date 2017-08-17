package com.my.flowersharm.model.domain;


import java.util.List;
import java.util.Set;

/**
 * @author Oleksii Petrokhalko.
 * 1. Цветочница. Определить иерархию цветов. Создать несколько объектов-
 * цветов. Собрать букет (используя аксессуары) с определением его
 * стоимости. Провести сортировку цветов в букете на основе уровня
 * свежести. Найти цветок в букете, соответствующий заданному диапазону
 * длин стеблей.
 */
public class Bouquet {
    private Long id;
    private String title;
    private Long price;
    private List<BouquetFlower> flowerList;
    private List<BouquetTree> treeList;
    private Set<BouquetAccessories> accessoriesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<BouquetFlower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<BouquetFlower> flowerList) {
        this.flowerList = flowerList;
    }

    public List<BouquetTree> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<BouquetTree> treeList) {
        this.treeList = treeList;
    }

    public Set<BouquetAccessories> getAccessoriesList() {
        return accessoriesList;
    }

    public void setAccessoriesList(Set<BouquetAccessories> accessoriesList) {
        this.accessoriesList = accessoriesList;
    }
}
