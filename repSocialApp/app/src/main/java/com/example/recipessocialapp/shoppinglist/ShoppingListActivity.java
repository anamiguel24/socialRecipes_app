package com.example.recipessocialapp.shoppinglist;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.createpost.CreatepostActivity;
import com.example.recipessocialapp.databinding.ActivityShoppinglistBinding;
import com.example.recipessocialapp.databinding.ActivityWeeklyplanBinding;
import com.example.recipessocialapp.feed.FeedActivity;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.weeklyplan.WeeklyPlanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ShoppingListActivity extends AppCompatActivity {
    private ActivityShoppinglistBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // bottom bar
        binding = ActivityShoppinglistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton backB = findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayout custom = (LinearLayout) findViewById(R.id.custom);

        ImageView plusB = findViewById(R.id.plusB);
        plusB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayout ly = new LinearLayout(getApplicationContext());
                ly.setOrientation(LinearLayout.HORIZONTAL);
                ly.setWeightSum(100);

                CheckBox ingredient = new CheckBox(getApplicationContext());
                ingredient.setWidth(500);
                ingredient.setTextSize(16);
                ingredient.setHeight(140);
                ingredient.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_200)));
                EditText ing = findViewById(R.id.TypedIngredient);
                ingredient.setText(ing.getText());

                TextView quantity = new TextView(getApplicationContext());
                EditText qty = findViewById(R.id.TypedQuantity);
                quantity.setText(qty.getText());
                quantity.setTextSize(16);
                quantity.setHeight(140);
                quantity.setTextColor(getResources().getColor(R.color.black));
                quantity.setWidth(500);

                ly.addView(ingredient);
                ly.addView(quantity);

                custom.addView(ly);

                ing.getText().clear();
                qty.getText().clear();
            }
        });



        BottomNavigationView bottom_bar = findViewById(R.id.bottom_bar);
        bottom_bar.setSelectedItemId(R.id.navigation_shoppinglist);

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
