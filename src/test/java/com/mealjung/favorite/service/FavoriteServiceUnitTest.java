package com.mealjung.favorite.service;

import com.mealjung.common.utils.enums.FavoriteType;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.entity.Favorite;
import com.mealjung.favorite.entity.FavoriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FavoriteServiceUnitTest {

    @Mock
    FavoriteRepository favoriteRepository;

    @InjectMocks
    FavoriteService favoriteService;

    @Test
    @DisplayName("좋아요 저장 - 성공")
    public void saveFavorite_success() {
        //given
        Long userId = 1L;
        FavoriteType type = FavoriteType.MENU;
        Long typeId = 2L;

        FavoriteSaveRequest request = FavoriteSaveRequest.builder()
                .userId(userId)
                .type(type.getValue())
                .typeId(typeId)
                .build();

        Favorite expectedFavorite = Favorite.create(userId, type.getValue(), typeId, false);

        when(favoriteRepository.findByUserIdAndTypeAndTypeId(userId, type, typeId))
                .thenReturn(Optional.empty());
        when(favoriteRepository.save(any(Favorite.class))).thenReturn(expectedFavorite);

        //when
        FavoriteResponse response = favoriteService.save(request);

        //then
        assertThat(response.getType()).isEqualTo(type.getValue());
        assertThat(response.getTypeId()).isEqualTo(typeId);
        assertThat(response.getOpen()).isFalse();
        assertThat(response.getDelete()).isFalse();
    }

    @Test
    @DisplayName("좋아요 저장 - 실패")
    public void saveFavorite_fail() {
        //given
        Long userId = 1L;
        FavoriteType type = FavoriteType.MENU;
        Long typeId = 2L;

        FavoriteSaveRequest request = FavoriteSaveRequest.builder()
                .userId(userId)
                .type(type.getValue())
                .typeId(typeId)
                .build();

        Favorite existingFavorite = Favorite.create(userId, type.getValue(), typeId, false);

        when(favoriteRepository.findByUserIdAndTypeAndTypeId(userId, type, typeId))
                .thenReturn(Optional.of(existingFavorite));

        //when & then
        assertThatThrownBy(() -> favoriteService.save(request))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 좋아요를 누르셨습니다.");
    }


}