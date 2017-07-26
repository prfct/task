package model.entity;

import java.util.List;

/**
 * @author Oleksii Petrokhalko.
 */
public class Bouquet {
    private Long id;
    private String name;
    private Long price;
    private Freshness freshnessType;
    private Price priceType;
    private Size sizeType;
    private Steam steamType;
    private BouquetType bouquetType;
    private List<Plant> plants;

}
