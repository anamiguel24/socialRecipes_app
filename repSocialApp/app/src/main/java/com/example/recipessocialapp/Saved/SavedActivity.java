package com.example.recipessocialapp.Saved;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.createpost.CreatepostActivity;
import com.example.recipessocialapp.databinding.ActivitySavedBinding;
import com.example.recipessocialapp.feed.FeedActivity;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.shoppinglist.ShoppingListActivity;
import com.example.recipessocialapp.weeklyplan.WeeklyPlanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SavedActivity extends AppCompatActivity {
    private ActivitySavedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySavedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton backB = findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // bottom
/*    BottomNavigationView bottom_bar = findViewById(R.id.bottom_bar);
        bottom_bar.getMenu().setGroupCheckable(0, false, true);

        bottom_bar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
            switch(item.getItemId()){
                case R.id.navigation_home:
                    startActivity(new Intent(getApplicationContext(), FeedActivity.class));
                    overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                    return true;
                case R.id.navigation_shoppinglist:
                    startActivity(new Intent(getApplicationContext(), ShoppingListActivity.class));
                    overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                    return true;
                case R.id.navigation_addrecipe:
                    startActivity(new Intent(getApplicationContext(), CreatepostActivity.class));
                    overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
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
    });*/
}
