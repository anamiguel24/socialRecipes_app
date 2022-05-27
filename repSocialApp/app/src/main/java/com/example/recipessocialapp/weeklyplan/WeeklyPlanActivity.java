package com.example.recipessocialapp.weeklyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.databinding.ActivityFeedBinding;
import com.example.recipessocialapp.databinding.ActivityMyprofileBinding;
import com.example.recipessocialapp.databinding.ActivityWeeklyplanBinding;
import com.example.recipessocialapp.feed.FeedActivity;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class WeeklyPlanActivity extends AppCompatActivity {
    private ActivityWeeklyplanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);








        // bottom bar
        binding = ActivityWeeklyplanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottom_bar = findViewById(R.id.bottom_bar);
        bottom_bar.setSelectedItemId(R.id.navigation_calendar);

        bottom_bar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()){
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), FeedActivity.class));
                        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                        return true;
                    case R.id.navigation_shoppinglist:
                        return true;
                    case R.id.navigation_addrecipe:
                        return true;
                    case R.id.navigation_calendar:
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
