package com.example.guest.myrestaurant.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.myrestaurant.Constants;
import com.example.guest.myrestaurant.R;
import com.example.guest.myrestaurant.adapters.FirebaseRestaurantViewHolder;
import com.example.guest.myrestaurant.models.Restaurant;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRestaurantListActivity extends AppCompatActivity {
    private DatabaseReference mRestaurantReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private Query restaurantQuery;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        mRestaurantReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANTS);
        restaurantQuery = mRestaurantReference.getRef();

        Log.d("TESTER", "Testing!");
        setUpFirebaseAdapter();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<Restaurant>()
                .setQuery(restaurantQuery, Restaurant.class)
                .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Restaurant, FirebaseRestaurantViewHolder>
                (options) {
            @Override
            public FirebaseRestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.restaurant_list_item, parent, false);
                return new FirebaseRestaurantViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(FirebaseRestaurantViewHolder holder, int position, Restaurant model) {
                holder.bindRestaurant(model);
            }
        };
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.stopListening();
    }
}
