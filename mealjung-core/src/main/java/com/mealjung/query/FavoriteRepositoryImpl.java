package com.mealjung.query;

import com.mealjung.common.converter.utils.EnumConverterUtils;
import com.mealjung.common.enums.FavoriteType;
import com.mealjung.config.querydsl.QuerydslRepositorySupport;
import com.mealjung.dto.favorite.FavoriteCondition;
import com.mealjung.dto.favorite.FavoriteResponse;
import com.mealjung.dto.favorite.QFavoriteResponse;
import com.mealjung.entity.Favorite;
import com.mealjung.repository.FavoriteRepositoryCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.mealjung.entity.QFavorite.favorite;
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


