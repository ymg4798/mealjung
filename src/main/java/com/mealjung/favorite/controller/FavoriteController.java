package com.mealjung.favorite.controller;

import com.mealjung.common.page.PageApiResponse;
import com.mealjung.common.response.ApiResponse;
import com.mealjung.common.response.annotation.ApiResponseAnnotation;
import com.mealjung.favorite.controller.dto.FavoriteCondition;
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

    @GetMapping("/favorites")
    public ApiResponse<PageApiResponse<FavoriteResponse>> favorites(FavoriteCondition condition) {
        return ApiResponse.response(null, PageApiResponse.create(favoriteService.findByIdAllDesc(condition)));
    }
}


