package com.mealjung.repository;

import com.mealjung.dto.favorite.FavoriteCondition;
import com.mealjung.dto.favorite.FavoriteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteRepositoryCustom {
    Page<FavoriteResponse> search(FavoriteCondition condition, Pageable pageable);
}


