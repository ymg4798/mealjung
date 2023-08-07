package com.mealjung.repository.favorite;

import com.mealjung.model.favorite.FavoriteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteRepositoryCustom {
    Page<FavoriteModel> search(String type, Pageable pageable);
}


