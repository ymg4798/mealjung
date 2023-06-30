package com.mealjung.provider.menu;

import com.mealjung.dto.menu.request.MenuParam;
import com.mealjung.dto.menu.request.MenuRegisterParam;
import com.mealjung.model.menu.MenuModel;
import com.mealjung.service.menu.MenuProvider;
import com.mealjung.service.menu.MenuService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 * 지난번 미팅 때 얘기한 api-server 측과 core 쪽을 연결하는 서비스
 * 메뉴 때문에 임시로 만들어 놓았으니 이름 정하시면 바꾸세요
 * provider 를 통한 조회는 그냥 controller 로 빼도 될 듯
 */
@Service
public class MenuBroker {
    private final MenuService menuService;
    private final MenuProvider menuProvider;
    public MenuBroker(MenuService menuService, MenuProvider menuProvider) {
        this.menuService = menuService;
        this.menuProvider = menuProvider;
    }

    public MenuModel findByNameAndRestaurant(MenuParam param) {
        return menuProvider.findByNameAndRestaurant(param.getName(), param.getRestaurantId());
    }

    public List<MenuModel> findMenusByName(String name){
        return menuProvider.findAllByName(name);
    }

    public List<MenuModel> findMenusByRestaurant(Long restaurantId){
        return menuProvider.findAllByRestaurant(restaurantId);
    }

    public MenuModel register(MenuRegisterParam param){
        return menuService.create(
                param.name,
                param.description,
                param.price,
                param.restaurantId,
                param.imageCode
        );
    }

    // TODO: 메뉴 업데이트 여기

    public void delete(MenuParam param){
        menuService.delete(param.getName(), param.getRestaurantId());
    }
}
