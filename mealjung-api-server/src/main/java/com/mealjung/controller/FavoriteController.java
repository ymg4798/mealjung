package com.mealjung.controller;

import com.mealjung.common.annotation.ApiResponseAnnotation;
import com.mealjung.common.aspect.dto.ApiResponse;
import com.mealjung.dto.favorite.FavoriteCondition;
import com.mealjung.dto.favorite.FavoriteSaveRequest;
import com.mealjung.dto.favorite.FavoriteUpdateRequest;
import com.mealjung.repository.favorite.FavoriteResponse;
import com.mealjung.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@ApiResponseAnnotation
@RequiredArgsConstructor
@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite")
    public ApiResponse<FavoriteResponse> save(@RequestBody FavoriteSaveRequest request) {
        return ApiResponse.response(null, favoriteService.save(request.toEntity()));
    }

    @PutMapping("/favorite/{id}")
    public ApiResponse<FavoriteResponse> update(@PathVariable("id") Long id, @RequestBody FavoriteUpdateRequest request) {
        return ApiResponse.response(null, favoriteService.update(id, request.getType(), request.getTypeId(), request.getOpen()));
    }

    @GetMapping("/favorites")
    public ApiResponse<Page<FavoriteResponse>> favorites(FavoriteCondition condition) {
        return ApiResponse.response(null, favoriteService.findByIdAllDesc(condition.getType(), condition.getPage()));
    }
}


