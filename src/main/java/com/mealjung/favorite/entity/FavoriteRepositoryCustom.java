package com.mealjung.favorite.entity;

import com.mealjung.favorite.controller.dto.FavoriteCondition;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteRepositoryCustom {
    Page<FavoriteResponse> search(FavoriteCondition condition, Pageable pageable);
}


