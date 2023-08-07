package com.mealjung.entity.menu;

import com.mealjung.entity.common.BaseTimeEntity;
import com.mealjung.model.menu.MenuModel;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Menu extends BaseTimeEntity {
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
    private LocalDateTime deletedDate;

    @Builder
    public Menu(String name, String description, int price, Long restaurantId, Long imageCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
        this.imageCode = imageCode;
    }

    public MenuModel toDomainModel(){
        return new MenuModel(name, description, price, restaurantId, imageCode);
    }

    // TODO: 메뉴 업데이트 메서드 필요하면 여기에
}
