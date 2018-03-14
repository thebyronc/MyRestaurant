package com.example.guest.myrestaurant;

import android.os.Build;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;


import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(RobolectricTestRunner.class)
/**
 * Created by Guest on 3/12/18.
 */

public class RestaurantsActivityTest {
    private RestaurantsActivity activity;
    private ListView mRestaurantListView;


    @Before
    public void setup() {
        activity = Robolectric.setupActivity(RestaurantsActivity.class);
        mRestaurantListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void restaurantListViewPopulates() {
        assertNotNull(mRestaurantListView.getAdapter());
        assertEquals(mRestaurantListView.getAdapter().getCount(), 15);
    }
}
