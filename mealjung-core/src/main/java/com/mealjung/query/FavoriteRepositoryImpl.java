package com.mealjung.query;

import com.mealjung.common.converter.utils.EnumConverterUtils;
import com.mealjung.common.enums.FavoriteType;
import com.mealjung.config.querydsl.QuerydslRepositorySupport;
import com.mealjung.entity.favorite.Favorite;
import com.mealjung.entity.favorite.QFavorite;
import com.mealjung.model.favorite.FavoriteModel;
import com.mealjung.model.favorite.QFavoriteModel;
import com.mealjung.repository.favorite.FavoriteRepositoryCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.mealjung.entity.favorite.QFavorite.favorite;
import static org.springframework.util.StringUtils.hasText;

@Repository
public class FavoriteRepositoryImpl extends QuerydslRepositorySupport implements FavoriteRepositoryCustom {

    public FavoriteRepositoryImpl() {
        super(Favorite.class);
    }

    @Override
    public Page<FavoriteModel> search(String type, Pageable pageable) {
        return applyPagination(pageable,
                contentQuery -> contentQuery
                        .select(new QFavoriteModel(
                                favorite.userId,
                                favorite.type,
                                favorite.typeId,
                                favorite.open))
                        .from(favorite)
                        .where(
                                favoriteTypeEq(type)
                        )
        ,countQuery -> countQuery
                        .select(favorite.count())
                        .from(favorite)
                        .where(
                                favoriteTypeEq(type)
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


