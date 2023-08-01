package com.mealjung.service.favorite;

import com.mealjung.common.page.PageRequest;
import com.mealjung.entity.favorite.Favorite;
import com.mealjung.model.favorite.FavoriteModel;
import com.mealjung.repository.favorite.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FavoriteProvider {

    private final FavoriteRepository favoriteRepository;

    public Page<FavoriteModel> findByIdAllDesc(String type, Integer page) {
        return favoriteRepository.search(type, new PageRequest(page).of());
    }

    public FavoriteModel findById(Long id) {
        return favoriteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 데이터가 존재하지 않습니다. id : " + id))
                .toDomainModel();
    }
}
