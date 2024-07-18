package com.jamjam.review.api;

import com.jamjam.review.api.request.CreateAndEditRestaurantRequest;
import com.jamjam.review.model.RestaurantEntity;
import com.jamjam.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "This is getRestaurants";
    }
    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(@PathVariable Long restaurantId) {
        return "This is getRestaurant, " + restaurantId;
    }
    // 생성
    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ){
//        return "This is createRestaurant, name = " + request.getName() +
//                "address = " + request.getAddress() + "menu[0].name = " + request.getMenus().get(0).getName()
//                + "menu[0].price = " + request.getMenus().get(0).getPrice();
            restaurantService.createRestaurant(request);
    }
    // 수정
    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
//        return "This is editRestaurant, " + restaurantId + "name = " + request.getName() + "address = " + request.getAddress();
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId) {
//        return "This is deleteRestaurant, " + restaurantId;
        restaurantService.deleteRestaurant(restaurantId);
    }
}
