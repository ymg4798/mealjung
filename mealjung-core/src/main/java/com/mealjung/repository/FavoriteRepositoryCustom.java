package com.mealjung.repository;

import com.mealjung.repository.favorite.FavoriteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteRepositoryCustom {
    Page<FavoriteResponse> search(String type, Pageable pageable);
}


