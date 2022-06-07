package com.example.recipessocialapp.feed;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.Saved.SavedActivity;
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
    private int clicks1=0,clicks2=0,clicks3=0,clicks4=0;
    private int sclicks1=0,sclicks2=0,sclicks3=0,sclicks4=0;
    private int shareclicks1=0,shareclicks2=0,shareclicks3=0,shareclicks4=0;

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

        View pc1 = findViewById(R.id.PostCard1);
        pc1.setOnClickListener(new View.OnClickListener() {
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

        View pc2 = findViewById(R.id.PostCard2);
        pc2.setOnClickListener(new View.OnClickListener() {
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

        View pc3 = findViewById(R.id.PostCard3);
        pc3.setOnClickListener(new View.OnClickListener() {
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

        View pc4 = findViewById(R.id.PostCard4);
        pc4.setOnClickListener(new View.OnClickListener() {
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

        View saved = findViewById(R.id.savedposts);
        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  SavedActivity.class));
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
                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_LONG);
                        View view = toast.getView();
                        view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                        TextView text = view.findViewById(android.R.id.message);
                        text.setTextColor(getResources().getColor(R.color.white));
                        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        toast.show();
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
                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_LONG);
                        View view = toast.getView();
                        view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                        TextView text = view.findViewById(android.R.id.message);
                        text.setTextColor(getResources().getColor(R.color.white));
                        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        toast.show();
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
                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_LONG);
                        View view = toast.getView();
                        view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                        TextView text = view.findViewById(android.R.id.message);
                        text.setTextColor(getResources().getColor(R.color.white));
                        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        toast.show();
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
                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "Recipe added on " + chosen_day +", "+ chosen_week,
                                Toast.LENGTH_LONG);
                        View view = toast.getView();
                        view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                        TextView text = view.findViewById(android.R.id.message);
                        text.setTextColor(getResources().getColor(R.color.white));
                        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        toast.show();
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

        ImageView like1 = findViewById(R.id.like1);
        like1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicks1%2==0)
                    like1.setImageResource(R.drawable.ic_baseline_thumb_up_24_pressed);
                else
                    like1.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                clicks1++;
            }
        });

        ImageView like2 = findViewById(R.id.like2);
        like2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicks2%2==0)
                    like2.setImageResource(R.drawable.ic_baseline_thumb_up_24_pressed);
                else
                    like2.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                clicks2++;
            }
        });

        ImageView like3 = findViewById(R.id.like3);
        like3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicks3%2==0)
                    like3.setImageResource(R.drawable.ic_baseline_thumb_up_24_pressed);
                else
                    like3.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                clicks3++;
            }
        });

        ImageView like4 = findViewById(R.id.like4);
        like4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicks4%2==0)
                    like4.setImageResource(R.drawable.ic_baseline_thumb_up_24_pressed);
                else
                    like4.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                clicks4++;
            }
        });


        ImageView save1 = findViewById(R.id.save1);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sclicks1%2==0) {
                    save1.setImageResource(R.drawable.ic_baseline_bookmark_24_pressed);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe saved!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                else {
                    save1.setImageResource(R.drawable.ic_baseline_bookmark_24);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe removed!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                sclicks1++;
            }
        });

        ImageView save2 = findViewById(R.id.save2);
        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sclicks2%2==0) {
                    save2.setImageResource(R.drawable.ic_baseline_bookmark_24_pressed);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe saved!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                else {
                    save2.setImageResource(R.drawable.ic_baseline_bookmark_24);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe removed!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                sclicks2++;
            }
        });

        ImageView save3 = findViewById(R.id.save3);
        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sclicks3%2==0) {
                    save3.setImageResource(R.drawable.ic_baseline_bookmark_24_pressed);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe saved!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                else {
                    save3.setImageResource(R.drawable.ic_baseline_bookmark_24);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe removed!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                sclicks3++;
            }
        });

        ImageView save4 = findViewById(R.id.save4);
        save4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sclicks4%2==0) {
                    save4.setImageResource(R.drawable.ic_baseline_bookmark_24_pressed);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe saved!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                else {
                    save4.setImageResource(R.drawable.ic_baseline_bookmark_24);
                    Toast toast = Toast.makeText(
                            getApplicationContext(),
                            "Recipe removed!",
                            Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    toast.show();
                }
                sclicks4++;
            }
        });

        View comment1 = findViewById(R.id.comment1);
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostActvity.class);
                intent.putExtra("who","comment");
                startActivity(intent);
            }
        });

        View comment2 = findViewById(R.id.comment2);
        comment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostActvity2.class);
                intent.putExtra("who","comment");
                startActivity(intent);
            }
        });

        View comment3 = findViewById(R.id.comment3);
        comment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostActvity3.class);
                intent.putExtra("who","comment");
                startActivity(intent);
            }
        });

        View comment4 = findViewById(R.id.comment4);
        comment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostActvity4.class);
                intent.putExtra("who","comment");
                startActivity(intent);
            }
        });

        ImageView share1 = findViewById(R.id.share1);
        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        "Link copied to clipboard!",
                        Toast.LENGTH_SHORT);
                View view = toast.getView();
                view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(getResources().getColor(R.color.white));
                text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                toast.show();
            }
        });

        ImageView share2 = findViewById(R.id.share2);
        share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        "Link copied to clipboard!",
                        Toast.LENGTH_SHORT);
                View view = toast.getView();
                view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(getResources().getColor(R.color.white));
                text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                toast.show();
            }
        });

        ImageView share3 = findViewById(R.id.share3);
        share3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        "Link copied to clipboard!",
                        Toast.LENGTH_SHORT);
                View view = toast.getView();
                view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(getResources().getColor(R.color.white));
                text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                toast.show();
            }
        });

        ImageView share4 = findViewById(R.id.share4);
        share4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        "Link copied to clipboard!",
                        Toast.LENGTH_SHORT);
                View view = toast.getView();
                view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(getResources().getColor(R.color.white));
                text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                toast.show();
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
