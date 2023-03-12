package com.mealjung.favorite.service;

import com.mealjung.common.utils.enums.FavoriteType;
import com.mealjung.common.utils.enums.converter.statics.EnumConverterUtils;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.controller.dto.FavoriteSaveResponse;
import com.mealjung.favorite.entity.Favorite;
import com.mealjung.favorite.entity.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteSaveResponse save(FavoriteSaveRequest request) {
        validateDuplicationFavorite(request.getType(), request.getTypeId());

        Favorite favorite = Favorite.create(request.getType(), request.getTypeId(), request.getTitle(), false);
        favoriteRepository.save(favorite);

        return FavoriteSaveResponse.create(favorite);
    }

    private void validateDuplicationFavorite(String type, Long typeId) {
        List<Favorite> favorite = favoriteRepository.findByTypeAndTypeId(EnumConverterUtils.ofEnum(FavoriteType.class, type), typeId);
        if(!favorite.isEmpty()) {
            throw new IllegalStateException("이미 좋아요를 누르셨습니다.");
        }
    }
}
