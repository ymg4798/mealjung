package com.mealjung.entity.menu;

import com.mealjung.model.menu.MenuModel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="menu")
@Where(clause = "deletedAt != null")
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int price;
    @Column
    private Long restaurantId;
    @Column
    private Long imageCode;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @Column
    private LocalDateTime deletedAt;

    public Menu(String name, String description, int price, Long restaurantId, Long imageCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
        this.imageCode = imageCode;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
        this.deletedAt = null;
    }

    public Menu(MenuModel model){
        this.name = model.getName();
        this.description = model.getDescription();
        this.price = model.getPrice();
        this.restaurantId = model.getRestaurantId();
        this.imageCode = model.getImageCode();
    }

    public MenuModel toDomainModel(){
        return new MenuModel(name, description, price, restaurantId, imageCode);
    }

    // TODO: 메뉴 업데이트 메서드 필요하면 여기에
}
