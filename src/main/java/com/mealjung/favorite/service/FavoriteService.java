package com.mealjung.favorite.service;

import com.mealjung.common.utils.enums.FavoriteType;
import com.mealjung.common.utils.enums.converter.statics.EnumConverterUtils;
import com.mealjung.favorite.controller.dto.FavoriteCondition;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.controller.dto.FavoriteUpdateRequest;
import com.mealjung.favorite.entity.Favorite;
import com.mealjung.favorite.entity.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Transactional
    public FavoriteResponse save(FavoriteSaveRequest request) {
        validateDuplicationFavorite(request.getType(), request.getTypeId());

        Favorite favorite = Favorite.create(request.getType(), request.getTypeId(), request.getTitle(), false);
        favoriteRepository.save(favorite);

        return FavoriteResponse.create(favorite);
    }

    private void validateDuplicationFavorite(String type, Long typeId) {
        List<Favorite> favorite = favoriteRepository.findByTypeAndTypeId(EnumConverterUtils.ofEnum(FavoriteType.class, type), typeId);
        if(!favorite.isEmpty()) {
            throw new IllegalStateException("이미 좋아요를 누르셨습니다.");
        }
    }

    @Transactional
    public FavoriteResponse update(Long id, FavoriteUpdateRequest request) {
        Favorite favorite = findById(id);
        favorite.update(request);
        return FavoriteResponse.create(favorite);
    }

    @Transactional
    public FavoriteResponse recordDeletion(Long id) {
        Favorite favorite = findById(id);
        favorite.delete();
        return FavoriteResponse.create(favorite);
    }

    public List<FavoriteResponse> findByIdAllDesc(FavoriteCondition condition) {

    }

    @Transactional(readOnly = true)
    public Favorite findById(Long id) {
        return favoriteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 데이터가 존재하지 않습니다. id : " + id));

    }
}
