package com.mealjung.controller;

import com.mealjung.common.annotation.ApiResponseAnnotation;
import com.mealjung.common.aspect.dto.ApiResponse;
import com.mealjung.dto.favorite.FavoriteSaveRequest;
import com.mealjung.dto.favorite.FavoriteUpdateRequest;
import com.mealjung.model.favorite.FavoriteModel;
import com.mealjung.service.favorite.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@ApiResponseAnnotation
@RequiredArgsConstructor
@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite")
    public ApiResponse<FavoriteModel> create(@RequestBody FavoriteSaveRequest request) {
        return ApiResponse.response(null, favoriteService.create(request.toEntity()));
    }

    @PutMapping("/favorite/{id}")
    public ApiResponse<FavoriteModel> update(@PathVariable("id") Long id, @RequestBody FavoriteUpdateRequest request) {
        return ApiResponse.response(null, favoriteService.update(id, request.getType(), request.getTypeId(), request.getOpen()));
    }
/*
    @GetMapping("/favorites")
    public ApiResponse<Page<FavoriteModel>> favorites(FavoriteCondition condition) {
        return ApiResponse.response(null, favoriteService.findByIdAllDesc(condition.getType(), condition.getPage()));
    }*/
}


