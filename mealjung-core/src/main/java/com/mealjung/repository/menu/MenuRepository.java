package com.mealjung.repository.menu;

import com.mealjung.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByNameAndRestaurantId(String name, Long restaurantId);
    List<Menu> findAllByNameLike(String name);
    List<Menu> findAllByRestaurantId(Long restaurantId);
}
