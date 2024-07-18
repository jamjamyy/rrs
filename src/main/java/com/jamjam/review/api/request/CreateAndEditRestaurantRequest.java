package com.jamjam.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

// 맛집 생성 API
@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantRequest {
    private final String name;
    private final String address;
    private final List<CreateAndEditRestaurantRequestMenu> menus;
}
