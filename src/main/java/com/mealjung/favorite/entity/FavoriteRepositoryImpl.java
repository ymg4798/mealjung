package com.mealjung.favorite.entity;

import com.mealjung.config.querydsl.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class FavoriteRepositoryImpl extends QuerydslRepositorySupport implements FavoriteRepositoryCustom {

    public FavoriteRepositoryImpl() {
        super(Favorite.class);
    }

}


