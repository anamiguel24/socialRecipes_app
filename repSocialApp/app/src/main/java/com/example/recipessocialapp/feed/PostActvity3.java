package com.example.recipessocialapp.feed;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.createpost.CreatepostActivity;
import com.example.recipessocialapp.databinding.ActivityPost2Binding;
import com.example.recipessocialapp.databinding.ActivityPost3Binding;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.profilePages.UserProfileActivity;
import com.example.recipessocialapp.profilePages.UserProfileActivity3;
import com.example.recipessocialapp.shoppinglist.ShoppingListActivity;
import com.example.recipessocialapp.weeklyplan.WeeklyPlanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class PostActvity3 extends AppCompatActivity {
    private ActivityPost3Binding binding;
    private CharSequence chosen_week="27 June - 03 July";
    private CharSequence chosen_day = "Monday";
    private int sclicks1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPost3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton backB = findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView user1 = findViewById(R.id.user);
        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostActvity3.this,  UserProfileActivity3.class));
            }
        });


        // ADD TO CALENDAR DROPDOWN MENU
        ImageView calendarB = (ImageView) findViewById(R.id.addcalendar);
        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup3 = new PopupMenu(getApplicationContext(), calendarB);
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
                PopupMenu popup = new PopupMenu(getApplicationContext(), calendarB);
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

                PopupMenu popup2 = new PopupMenu(getApplicationContext(), calendarB);
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

        CardView cv4 = findViewById(R.id.PostCard4);
        EditText typedcomment = findViewById(R.id.editTextTextPersonName);
        TextView oldcom = findViewById(R.id.patrickscomment);
        Button s = findViewById(R.id.button4);

        s.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                oldcom.setText(typedcomment.getText());
                cv4.setVisibility(View.VISIBLE);
            }
        });

        Intent intent = getIntent();
        if(intent.hasExtra("who")) {

            ScrollView sv = findViewById(R.id.scroll_feed);
            sv.post(new Runnable() {
                @Override
                public void run() {
                    sv.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
        }

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

        // bottom bar
        BottomNavigationView bottom_bar = findViewById(R.id.bottom_bar);
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
        });
    }
}
