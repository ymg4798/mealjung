package com.mealjung.repository;

import com.mealjung.common.enums.FavoriteType;
import com.mealjung.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>, FavoriteRepositoryCustom{

    @Query("select f from Favorite f where f.userId = :userId and f.type = :type and f.typeId = :typeId")
    Optional<Favorite> findByUserIdAndTypeAndTypeId(@Param("userId") Long userId, @Param("type") FavoriteType type, @Param("typeId") Long typeId);
}


