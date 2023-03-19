package com.mealjung.favorite.controller;

import com.mealjung.favorite.entity.Favorite;
import com.mealjung.favorite.entity.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import static com.mealjung.favorite.entity.Favorite.create;

@RequiredArgsConstructor
@Component
public class FavoriteConstruct {

    private final FavoriteRepository favoriteRepository;

    //리뷰, 식당, 메뉴
    @Transactional
    @PostConstruct
    public void initFavorite() {
        for (int i = 1; i <= 11; i++) {
            favoriteRepository.save(create(1L, "리뷰", (long) i, false));
        }

        for (int i = 1; i <= 9; i++) {
            favoriteRepository.save(create(1L, "식당", (long) i, false));
        }

        for (int i = 1; i <= 22; i++) {
            favoriteRepository.save(create(1L, "메뉴", (long) i, false));
        }
    }
}
