package com.mealjung.service;

import com.mealjung.common.converter.utils.EnumConverterUtils;
import com.mealjung.common.enums.FavoriteType;
import com.mealjung.dto.favorite.FavoriteCondition;
import com.mealjung.dto.favorite.FavoriteResponse;
import com.mealjung.dto.favorite.FavoriteSaveRequest;
import com.mealjung.dto.favorite.FavoriteUpdateRequest;
import com.mealjung.entity.Favorite;
import com.mealjung.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    /**
     * 1. 좋아요 누름
     * 2. 취소 하면 true업데이트
     * 3. 업데이트 false
     * 4. 200번 클릭하면 200개 쌓인다.
     */
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

    /**
     * 현재 좋아요 했던 내용도 보여준다.
     */
    public Page<FavoriteResponse> findByIdAllDesc(FavoriteCondition condition) {
        return favoriteRepository.search(condition, new PageRequest(condition.getPage()).of());
    }

    public Favorite findById(Long id) {
        return favoriteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 데이터가 존재하지 않습니다. id : " + id));
    }

}


