package com.mealjung.favorite.service;

import com.mealjung.common.page.PageRequest;
import com.mealjung.common.utils.enums.FavoriteType;
import com.mealjung.common.utils.enums.converter.statics.EnumConverterUtils;
import com.mealjung.favorite.controller.dto.FavoriteCondition;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.controller.dto.FavoriteUpdateRequest;
import com.mealjung.favorite.entity.Favorite;
import com.mealjung.favorite.entity.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Transactional
    public FavoriteResponse save(FavoriteSaveRequest request) {
        Long userId = request.getUserId();// 로그인 작업후 변경 예정
        FavoriteType type = EnumConverterUtils.ofEnum(FavoriteType.class, request.getType());
        Optional<Favorite> favorite = favoriteRepository.findByUserIdAndTypeAndTypeId(userId, type, request.getTypeId());

        if (favorite.isPresent()) {
            throw new IllegalStateException("이미 좋아요를 누르셨습니다.");
        }

        Favorite newFavorite = new Favorite(userId, type, request.getTypeId(), false);
        favoriteRepository.save(newFavorite);

        return FavoriteResponse.create(newFavorite);
    }

    @Transactional
    public FavoriteResponse update(Long id, FavoriteUpdateRequest request) {
        Favorite favorite = findById(id);
        favorite.update(request);
        return FavoriteResponse.create(favorite);
    }

    public Page<FavoriteResponse> findByIdAllDesc(FavoriteCondition condition) {
        return favoriteRepository.search(condition, new PageRequest(condition.getPage()).of());
    }

    public Favorite findById(Long id) {
        return favoriteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 데이터가 존재하지 않습니다. id : " + id));
    }
}
