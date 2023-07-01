package com.mealjung.service.menu;

import com.mealjung.entity.menu.Menu;
import com.mealjung.model.menu.MenuModel;
import com.mealjung.repository.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuProvider {

    private final MenuRepository menuRepository;

    public MenuModel findByNameAndRestaurant(String name, Long restaurantId) {
        return menuRepository.findByNameAndRestaurantId(name, restaurantId).toDomainModel();
    }

    public List<MenuModel> findAllByName(String name){
        return menuRepository.findAllByNameLike(name)
                .stream()
                .map(Menu::toDomainModel)
                .collect(Collectors.toList());
    }

    public List<MenuModel> findAllByRestaurant(Long restaurantId) {
        return menuRepository.findAllByRestaurantId(restaurantId)
                .stream()
                .map(Menu::toDomainModel)
                .collect(Collectors.toList());
    }
}
