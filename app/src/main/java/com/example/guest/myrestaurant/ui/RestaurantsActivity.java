package com.example.guest.myrestaurant.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.myrestaurant.Constants;
import com.example.guest.myrestaurant.R;
import com.example.guest.myrestaurant.models.Restaurant;
import com.example.guest.myrestaurant.util.OnRestaurantSelectedListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity implements OnRestaurantSelectedListener {
    private Integer mPosition;
    ArrayList<Restaurant> mRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        if (savedInstanceState != null) {

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                mPosition = savedInstanceState.getInt(Constants.EXTRA_KEY_POSITION);
                mRestaurants = Parcels.unwrap(savedInstanceState.getParcelable(Constants.EXTRA_KEY_RESTAURANTS));

                if (mPosition != null && mRestaurants != null) {
                    Intent intent = new Intent(this, RestaurantDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition);
                    intent.putExtra(Constants.EXTRA_KEY_RESTAURANTS, Parcels.wrap(mRestaurants));
                    startActivity(intent);
                }

            }

        }

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mPosition != null && mRestaurants != null) {
            outState.putInt(Constants.EXTRA_KEY_POSITION, mPosition);
            outState.putParcelable(Constants.EXTRA_KEY_RESTAURANTS, Parcels.wrap(mRestaurants));
        }

    }

    @Override
    public void onRestaurantSelected(Integer position, ArrayList<Restaurant> restaurants) {
        mPosition = position;
        mRestaurants = restaurants;
    }

}
