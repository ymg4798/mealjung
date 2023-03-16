package com.mealjung.favorite.controller;

import com.mealjung.common.response.ApiResponse;
import com.mealjung.common.response.annotation.ApiResponseAnnotation;
import com.mealjung.favorite.controller.dto.FavoriteResponse;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.controller.dto.FavoriteUpdateRequest;
import com.mealjung.favorite.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@ApiResponseAnnotation
@RequiredArgsConstructor
@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite")
    public ApiResponse<FavoriteResponse> save(@RequestBody FavoriteSaveRequest request) {
        return ApiResponse.response(null, favoriteService.save(request));
    }

    @PutMapping("/favorite/{id}")
    public ApiResponse<FavoriteResponse> update(@PathVariable("id") Long id, @RequestBody FavoriteUpdateRequest request) {
        return ApiResponse.response(null, favoriteService.update(id, request));
    }

    @PatchMapping("/favorite/record-deletion/{id}")
    public ApiResponse<FavoriteResponse> recordDeletion(@PathVariable("id") Long id) {
        return ApiResponse.response(null, favoriteService.recordDeletion(id));
    }
}


