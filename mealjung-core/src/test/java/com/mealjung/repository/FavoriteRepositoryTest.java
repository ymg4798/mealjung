package com.mealjung.repository;

import com.mealjung.entity.Favorite;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class FavoriteRepositoryTest {

    @Autowired FavoriteRepository favoriteRepository;

    @Test
    public void 테스트() {
        List<Favorite> favorites = favoriteRepository.findAll();

        log.info(favorites.toString());
    }

}