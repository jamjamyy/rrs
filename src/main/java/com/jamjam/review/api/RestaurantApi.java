package com.jamjam.review.api;

import com.jamjam.review.api.request.CreateAndEditRestaurantRequest;
import com.jamjam.review.api.response.RestaurantDetailView;
import com.jamjam.review.api.response.RestaurantView;
import com.jamjam.review.model.RestaurantEntity;
import com.jamjam.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();
//        return List.of(RestaurantView.builder().id(0L).name("testName")
//                .address("testAddress").createdAt(ZonedDateTime.now())
//                .updatedAt(ZonedDateTime.now()).build());
    }
    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(@PathVariable Long restaurantId) {
        return restaurantService.getRestaurant(restaurantId);
//        return RestaurantDetailView.builder()
//                .id(0L)
//                .name("testName")
//                .address("testAddress")
//                .createAt(ZonedDateTime.now())
//                .updateAt(ZonedDateTime.now())
//                .menus(List.of(
//                        RestaurantDetailView.Menu.builder()
//                                .id(0L)
//                                .name("test Menu Name")
//                                .price(500)
//                                .createdAt(ZonedDateTime.now())
//                                .updatedAt(ZonedDateTime.now())
//                                .build()
//                ))
//                .build();
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
