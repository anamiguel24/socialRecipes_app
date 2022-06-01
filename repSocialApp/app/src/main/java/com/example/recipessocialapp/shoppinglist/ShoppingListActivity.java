package com.example.recipessocialapp.shoppinglist;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

        View plusB = findViewById(R.id.plusB);
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

                Spinner units = findViewById(R.id.units_spinner);

                TextView quantity = new TextView(getApplicationContext());
                EditText qty = findViewById(R.id.TypedQuantity);
                if (! (units.getSelectedItem().toString().equals("--")))
                    quantity.setText(qty.getText() + " " + units.getSelectedItem().toString());
                else
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

        Spinner spinner = (Spinner) findViewById(R.id.units_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        View save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        "Your changes were saved!",
                        Toast.LENGTH_LONG);
                View view = toast.getView();
                //Gets the actual oval background of the Toast then sets the colour filter
                view.getBackground().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_IN);
                //Gets the TextView from the Toast so it can be editted
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(getResources().getColor(R.color.white));
                text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                toast.show();
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
