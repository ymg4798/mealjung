package com.mealjung.favorite.entity;

import com.mealjung.common.utils.enums.FavoriteType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DisplayName("좋아요 Repository")
@DataJpaTest
class FavoriteRepositoryTest {

    @Autowired FavoriteRepository favoriteRepository;

    @AfterEach
    public void clear(){
        favoriteRepository.deleteAll();
    }

    @Test
    @DisplayName("좋아요 저장")
    public void save() {
        //given
        Favorite request =
                Favorite.create(1L, FavoriteType.MENU.getValue(), 1L, true);

        //when
        Favorite favorite = favoriteRepository.save(request);

        //then
        assertThat(request.getType()).isEqualTo(favorite.getType());
        assertThat(request.getUserId()).isEqualTo(favorite.getUserId());
        assertThat(request.getTypeId()).isEqualTo(favorite.getTypeId());
        assertThat(request.isOpen()).isEqualTo(favorite.isOpen());
    }

    @Test
    @DisplayName("좋아요 조회")
    public void findById() {
        //given
        Favorite request =
                Favorite.create(1L, FavoriteType.MENU.getValue(), 1L, true);

        //when
        Long id = favoriteRepository.save(request).getId();
        Favorite favorite = favoriteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. id = " + id));

        //then
        assertThat(request.getType()).isEqualTo(favorite.getType());
        assertThat(request.getUserId()).isEqualTo(favorite.getUserId());
        assertThat(request.getTypeId()).isEqualTo(favorite.getTypeId());
        assertThat(request.isOpen()).isEqualTo(favorite.isOpen());
    }
}


