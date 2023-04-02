package com.mealjung.favorite.service;

import com.mealjung.common.utils.enums.FavoriteType;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.controller.dto.FavoriteUpdateRequest;
import com.mealjung.favorite.entity.Favorite;
import com.mealjung.favorite.entity.FavoriteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FavoriteServiceIntegrationTest {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    FavoriteRepository favoriteRepository;

    @Test
    @DisplayName("좋아요 수정 - 성공")
    public void updateFavorite_success() {
        //given
        Long userId = 1L;
        FavoriteType type = FavoriteType.MENU;
        Long typeId = 2L;

        Favorite favorite = Favorite.create(userId, type.getValue(), typeId, false);

        FavoriteUpdateRequest updateRequest = FavoriteUpdateRequest.builder()
                .type("리뷰")
                .open(true)
                .typeId(2L)
                .build();

        Long favoriteId = favoriteRepository.save(favorite).getId();

        //when
        FavoriteResponse response = favoriteService.update(favoriteId, updateRequest);

        //then
        assertThat(response.getType()).isEqualTo(updateRequest.getType());
        assertThat(response.getOpen()).isTrue();
    }

}
