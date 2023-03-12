package com.mealjung.favorite.entity;

import com.mealjung.common.utils.enums.FavoriteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    @Query("select f from Favorite f where f.type = :type and f.typeId = :typeId")
    List<Favorite> findByTypeAndTypeId(@Param("type") FavoriteType type, @Param("typeId") Long typeId);
}


