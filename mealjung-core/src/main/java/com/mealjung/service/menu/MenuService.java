package com.mealjung.service.menu;

import com.mealjung.entity.menu.Menu;
import com.mealjung.model.menu.MenuModel;
import com.mealjung.repository.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuModel create(String name, String description, int price, Long restaurantId, Long imageCode){
        Menu menu = menuRepository.findByNameAndRestaurantId(name, restaurantId);
        if(menu == null){
            menu = MenuModel.create(name, description, price, restaurantId, imageCode);
            menuRepository.save(menu);
        }
        return menu.toDomainModel();
    }

    // TODO: 메뉴 업데이트 필요하면 여기에

    public void delete(String name, Long restaurantId){
        menuRepository.findByNameAndRestaurantId(name, restaurantId);
    }
}
