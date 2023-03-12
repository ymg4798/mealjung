package com.mealjung.favorite.controller;

import com.mealjung.common.response.ApiResponse;
import com.mealjung.common.response.annotation.ApiResponseAnnotation;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.controller.dto.FavoriteSaveResponse;
import com.mealjung.favorite.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@ApiResponseAnnotation
@RequiredArgsConstructor
@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite")
    public ApiResponse<FavoriteSaveResponse> save(@RequestBody FavoriteSaveRequest request) {
        return ApiResponse.response(null, favoriteService.save(request));
    }
}


