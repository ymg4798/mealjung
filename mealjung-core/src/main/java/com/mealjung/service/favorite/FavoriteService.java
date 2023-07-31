package com.mealjung.service.favorite;

import com.mealjung.common.enums.FavoriteType;
import com.mealjung.common.page.PageRequest;
import com.mealjung.repository.favorite.FavoriteResponse;
import com.mealjung.entity.favorite.Favorite;
import com.mealjung.repository.favorite.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
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
    public FavoriteResponse save(Favorite favorite) {
        Long userId = favorite.getUserId();
        FavoriteType type = favorite.getType();
        Long typeId = favorite.getTypeId();

        Optional<Favorite> findFavorite = favoriteRepository.findByUserIdAndTypeAndTypeId(userId, type, typeId);

        if (findFavorite.isPresent()) {
            throw new IllegalStateException("이미 좋아요를 누르셨습니다.");
        }

        favoriteRepository.save(favorite);

        return FavoriteResponse.create(favorite);
    }

    public FavoriteResponse update(Long id, String type, Long typeId, Boolean open) {
        Favorite favorite = favoriteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 좋아요 정보가 없습니다. id : " + id));
        favorite.update(type, typeId, open);
        return FavoriteResponse.create(favorite);
    }
}
