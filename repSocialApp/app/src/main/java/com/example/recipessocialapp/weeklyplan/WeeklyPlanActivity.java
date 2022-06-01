package com.example.recipessocialapp.weeklyplan;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.createpost.CreatepostActivity;
import com.example.recipessocialapp.databinding.ActivityFeedBinding;
import com.example.recipessocialapp.databinding.ActivityMyprofileBinding;
import com.example.recipessocialapp.databinding.ActivityUserprofile1Binding;
import com.example.recipessocialapp.databinding.ActivityWeeklyplanBinding;
import com.example.recipessocialapp.feed.FeedActivity;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.shoppinglist.ShoppingListActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class WeeklyPlanActivity extends AppCompatActivity {
    private ActivityWeeklyplanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWeeklyplanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton backB = findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding = ActivityWeeklyplanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // WEEK BUTTON
        Button week = (Button) findViewById(R.id.week);
        week.setText("27 June - 03 July");
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(WeeklyPlanActivity.this, week);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.choose_week_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                item.getTitle(),
                                Toast.LENGTH_SHORT);
                        View view = toast.getView();
                        view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                        TextView text = view.findViewById(android.R.id.message);
                        text.setTextColor(getResources().getColor(R.color.white));
                        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        toast.show();
                        week.setText(item.getTitle());
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener metho

        // bottom bar

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
                        startActivity(new Intent(getApplicationContext(), ShoppingListActivity.class));
                        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                        return true;
                    case R.id.navigation_addrecipe:
                        startActivity(new Intent(getApplicationContext(), CreatepostActivity.class));
                        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
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
