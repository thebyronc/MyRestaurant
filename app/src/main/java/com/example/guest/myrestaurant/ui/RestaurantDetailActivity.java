package com.example.guest.myrestaurant.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.myrestaurant.Constants;
import com.example.guest.myrestaurant.R;
import com.example.guest.myrestaurant.adapters.RestaurantPagerAdapter;
import com.example.guest.myrestaurant.models.Restaurant;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RestaurantDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private RestaurantPagerAdapter adapterViewPager;
    ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ButterKnife.bind(this);

        mRestaurants = Parcels.unwrap(getIntent().getParcelableExtra(Constants.EXTRA_KEY_RESTAURANTS));
        int startingPosition = getIntent().getIntExtra(Constants.EXTRA_KEY_POSITION, 0);

        adapterViewPager = new RestaurantPagerAdapter(getSupportFragmentManager(), mRestaurants);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
