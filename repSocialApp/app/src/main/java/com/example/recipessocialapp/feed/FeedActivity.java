package com.example.recipessocialapp.feed;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.createpost.CreatepostActivity;
import com.example.recipessocialapp.profilePages.UserProfileActivity2;
import com.example.recipessocialapp.profilePages.UserProfileActivity3;
import com.example.recipessocialapp.search.SearchRecipesActivity;
import com.example.recipessocialapp.shoppinglist.ShoppingListActivity;
import com.example.recipessocialapp.databinding.ActivityFeedBinding;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.profilePages.UserProfileActivity;
import com.example.recipessocialapp.weeklyplan.WeeklyPlanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FeedActivity extends AppCompatActivity {
    private ActivityFeedBinding binding;
    private CharSequence chosen_week="27 June - 03 July";
    private CharSequence chosen_day = "Monday";

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
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity2.class));
            }
        });

        AppCompatImageView image2 = findViewById(R.id.image2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  PostActvity2.class));
            }
        });

        TextView user3 = findViewById(R.id.user3);
        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity3.class));
            }
        });

        AppCompatImageView image3 = findViewById(R.id.image3);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  PostActvity3.class));
            }
        });

        TextView user4 = findViewById(R.id.user4);
        user4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity.class));
            }
        });

        AppCompatImageView image4 = findViewById(R.id.image4);
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  PostActvity4.class));
            }
        });

        View search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  SearchRecipesActivity.class));
            }
        });

        // ADD TO CALENDAR DROPDOWN MENU
        ImageView calendarB = (ImageView) findViewById(R.id.addcalendar);

        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup3 = new PopupMenu(FeedActivity.this, calendarB);
                //Inflating the Popup using xml file
                popup3.getMenuInflater()
                        .inflate(R.menu.portions_menu, popup3.getMenu());

                //registering popup with OnMenuItemClickListener
                popup3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                FeedActivity.this,
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(FeedActivity.this, calendarB);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.add_to_calendar_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_day=item.getTitle();
                        popup3.show();
                        return true;
                    }
                });

                PopupMenu popup2 = new PopupMenu(FeedActivity.this, calendarB);
                //Inflating the Popup using xml file
                popup2.getMenuInflater()
                        .inflate(R.menu.choose_week_menu, popup2.getMenu());

                //registering popup with OnMenuItemClickListener
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_week=item.getTitle();
                        popup.show();
                        return true;
                    }
                });

                popup2.show();
            }
        });

        ImageView calendarB2 = (ImageView) findViewById(R.id.addcalendar2);
        calendarB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup3 = new PopupMenu(FeedActivity.this, calendarB2);
                //Inflating the Popup using xml file
                popup3.getMenuInflater()
                        .inflate(R.menu.portions_menu, popup3.getMenu());

                //registering popup with OnMenuItemClickListener
                popup3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                FeedActivity.this,
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(FeedActivity.this, calendarB2);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.add_to_calendar_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_day=item.getTitle();
                        popup3.show();
                        return true;
                    }
                });

                PopupMenu popup2 = new PopupMenu(FeedActivity.this, calendarB2);
                //Inflating the Popup using xml file
                popup2.getMenuInflater()
                        .inflate(R.menu.choose_week_menu, popup2.getMenu());

                //registering popup with OnMenuItemClickListener
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_week=item.getTitle();
                        popup.show();
                        return true;
                    }
                });

                popup2.show();
            }
        });

        ImageView calendarB3 = (ImageView) findViewById(R.id.addcalendar3);
        calendarB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup3 = new PopupMenu(FeedActivity.this, calendarB3);
                //Inflating the Popup using xml file
                popup3.getMenuInflater()
                        .inflate(R.menu.portions_menu, popup3.getMenu());

                //registering popup with OnMenuItemClickListener
                popup3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                FeedActivity.this,
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(FeedActivity.this, calendarB3);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.add_to_calendar_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_day=item.getTitle();
                        popup3.show();
                        return true;
                    }
                });

                PopupMenu popup2 = new PopupMenu(FeedActivity.this, calendarB3);
                //Inflating the Popup using xml file
                popup2.getMenuInflater()
                        .inflate(R.menu.choose_week_menu, popup2.getMenu());

                //registering popup with OnMenuItemClickListener
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_week=item.getTitle();
                        popup.show();
                        return true;
                    }
                });

                popup2.show();
            }
        });

        ImageView calendarB4 = (ImageView) findViewById(R.id.addcalendar4);
        calendarB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup3 = new PopupMenu(FeedActivity.this, calendarB4);
                //Inflating the Popup using xml file
                popup3.getMenuInflater()
                        .inflate(R.menu.portions_menu, popup3.getMenu());

                //registering popup with OnMenuItemClickListener
                popup3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                FeedActivity.this,
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(FeedActivity.this, calendarB4);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.add_to_calendar_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_day=item.getTitle();
                        popup3.show();
                        return true;
                    }
                });

                PopupMenu popup2 = new PopupMenu(FeedActivity.this, calendarB4);
                //Inflating the Popup using xml file
                popup2.getMenuInflater()
                        .inflate(R.menu.choose_week_menu, popup2.getMenu());

                //registering popup with OnMenuItemClickListener
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        chosen_week=item.getTitle();
                        popup.show();
                        return true;
                    }
                });

                popup2.show();
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
        });


    }
}
