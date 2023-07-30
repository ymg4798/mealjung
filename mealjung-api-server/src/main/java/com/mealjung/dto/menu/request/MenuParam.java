package com.mealjung.dto.menu.request;

public class MenuParam {
    private final String name;
    private final Long restaurantId;

    public MenuParam(String name, Long restaurantId) {
        this.name = name;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }
}
