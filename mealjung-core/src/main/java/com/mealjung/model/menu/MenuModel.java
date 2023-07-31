package com.mealjung.model.menu;

import com.mealjung.entity.menu.Menu;

public class MenuModel {

    private final String name;

    private final String description;

    private final int price;

    private final Long restaurantId;

    private final Long imageCode;

    public MenuModel(String name, String description, int price, Long restaurantId, Long imageCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
        this.imageCode = imageCode;
    }

    public static Menu create(String name, String description, int price, Long restaurantId, Long imageCode) {
        return Menu.builder()
                .name(name)
                .description(description)
                .price(price)
                .restaurantId(restaurantId)
                .imageCode(imageCode)
                .build();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Long getImageCode() {
        return imageCode;
    }
}
