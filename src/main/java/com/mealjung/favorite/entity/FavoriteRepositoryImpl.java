package com.mealjung.favorite.entity;

import com.mealjung.config.querydsl.QuerydslRepositorySupport;
import com.mealjung.favorite.controller.dto.FavoriteCondition;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import com.mealjung.favorite.controller.dto.QFavoriteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.mealjung.favorite.entity.QFavorite.favorite;

@Repository
public class FavoriteRepositoryImpl extends QuerydslRepositorySupport implements FavoriteRepositoryCustom {

    public FavoriteRepositoryImpl() {
        super(Favorite.class);
    }

    @Override
    public Page<FavoriteResponse> search(FavoriteCondition condition, Pageable pageable) {
        return applyPagination(pageable,
                contentQuery -> contentQuery
                        .select(new QFavoriteResponse(
                                favorite.type,
                                favorite.typeId,
                                favorite.title,
                                favorite.open,
                                favorite.delete)));
    }
}


