package com.example.guest.myrestaurant.util;

import com.example.guest.myrestaurant.models.Restaurant;

import java.util.ArrayList;

/**
 * Created by Guest on 4/4/18.
 */

public interface OnRestaurantSelectedListener {
    public void onRestaurantSelected(Integer position, ArrayList<Restaurant> restaurants, String source);
}
