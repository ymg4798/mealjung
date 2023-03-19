package com.mealjung.favorite.entity;

import com.mealjung.common.utils.enums.FavoriteType;
import com.mealjung.common.utils.enums.converter.statics.EnumConverterUtils;
import com.mealjung.config.querydsl.QuerydslRepositorySupport;
import com.mealjung.favorite.controller.dto.FavoriteCondition;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import com.mealjung.favorite.controller.dto.QFavoriteResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.mealjung.favorite.entity.QFavorite.favorite;
import static org.springframework.util.StringUtils.hasText;

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
                                favorite.open,
                                favorite.delete))
                        .from(favorite)
                        .where(
                                favoriteTypeEq(condition.getType())
                        )
        ,countQuery -> countQuery
                        .select(favorite.count())
                        .from(favorite)
                        .where(
                                favoriteTypeEq(condition.getType())
                        ));
    }

    private BooleanExpression favoriteTypeEq(String type) {
        FavoriteType favoriteType = EnumConverterUtils.ofEnum(FavoriteType.class, type);
        return hasText(type) ? favorite.type.eq(favoriteType) : null;
    }

    private BooleanExpression stringContains(StringPath path, String value) {
        return hasText(value) ? path.contains(value) : null;
    }
}


