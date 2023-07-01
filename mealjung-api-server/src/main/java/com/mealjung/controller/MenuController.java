package com.mealjung.controller;

import com.mealjung.dto.menu.request.MenuParam;
import com.mealjung.dto.menu.request.MenuRegisterParam;
import com.mealjung.provider.menu.MenuBroker;
import com.mealjung.model.menu.MenuModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuBroker menuBroker;

    @GetMapping("/search")
    public MenuModel findByNameAndRestaurant(@RequestParam MenuParam param) {
        return menuBroker.findByNameAndRestaurant(param);
    }

    @GetMapping("/search/name")
    public List<MenuModel> findAllByName(@RequestParam String name) {
        return menuBroker.findMenusByName(name);
    }

    @GetMapping("/search/restaurant")
    public List<MenuModel> findAllByRestaurant(@RequestParam Long restaurantId) {
        return menuBroker.findMenusByRestaurant(restaurantId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuModel create(@RequestBody MenuRegisterParam param) {
        return menuBroker.register(param);
    }

    // TODO: 메뉴 업데이트 필요하면 여기

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam MenuParam param) {
        menuBroker.delete(param);
    }
}
