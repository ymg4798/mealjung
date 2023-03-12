package com.mealjung.favorite.controller;

import com.mealjung.favorite.annotation.FavoriteResponse;
import com.mealjung.favorite.controller.dto.FavoriteApiResponse;
import com.mealjung.favorite.controller.dto.FavoriteSaveRequest;
import com.mealjung.favorite.controller.dto.FavoriteSaveResponse;
import com.mealjung.favorite.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@FavoriteResponse
@RequiredArgsConstructor
@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite")
    public FavoriteApiResponse<FavoriteSaveResponse> save(@RequestBody FavoriteSaveRequest request) {
        return FavoriteApiResponse.response(null, favoriteService.save(request));
    }
}


