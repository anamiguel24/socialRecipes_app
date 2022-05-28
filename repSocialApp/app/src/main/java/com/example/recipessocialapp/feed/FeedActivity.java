package com.example.recipessocialapp.feed;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.ShoppingListActivity;
import com.example.recipessocialapp.databinding.ActivityFeedBinding;
import com.example.recipessocialapp.databinding.ActivityMyprofileBinding;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.profilePages.UserProfileActivity;
import com.example.recipessocialapp.weeklyplan.WeeklyPlanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FeedActivity extends AppCompatActivity {
    private ActivityFeedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView user1 = findViewById(R.id.user1);

        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity.class));
            }
        });

        AppCompatImageView image1 = findViewById(R.id.image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  PostActvity.class));
            }
        });

        TextView user2 = findViewById(R.id.user2);
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity.class));
            }
        });

        TextView user3 = findViewById(R.id.user3);
        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity.class));
            }
        });


        // bottom bar
        BottomNavigationView bottom_bar = findViewById(R.id.bottom_bar);
        bottom_bar.setSelectedItemId(R.id.navigation_home);

        bottom_bar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()){
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_shoppinglist:
                        startActivity(new Intent(getApplicationContext(), ShoppingListActivity.class));
                        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                        return true;
                    case R.id.navigation_addrecipe:
                        return true;
                    case R.id.navigation_calendar:
                        startActivity(new Intent(getApplicationContext(), WeeklyPlanActivity.class));
                        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                        return true;
                    case R.id.navigation_myprofile:
                        startActivity(new Intent(getApplicationContext(), MyProfileActivity.class));
                        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                        return true;
                }
                return false;
            }
        });


    }
}
