package com.example.guest.myrestaurant;

import android.content.Intent;
import android.widget.TextView;

import com.example.guest.myrestaurant.ui.MainActivity;
import com.example.guest.myrestaurant.ui.RestaurantsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;


@RunWith(RobolectricTestRunner.class)
/**
 * Created by Guest on 3/12/18.
 */

public class MainActivityTest {
    private MainActivity activity;
    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView appNameTextView = (TextView) activity.findViewById(R.id.appNameTextView);
        assertTrue("My Restaurants".equals(appNameTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted() {
        activity.findViewById(R.id.findRestaurantsButton).performClick();
        Intent expectedIntent = new Intent(activity, RestaurantsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

}
