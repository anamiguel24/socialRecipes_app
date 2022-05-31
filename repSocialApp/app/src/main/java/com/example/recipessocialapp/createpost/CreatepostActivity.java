package com.example.recipessocialapp.createpost;

import android.content.Intent;
import android.content.res.ColorStateList;
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
import com.example.recipessocialapp.databinding.ActivityCreatepostBinding;
import com.example.recipessocialapp.feed.FeedActivity;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.shoppinglist.ShoppingListActivity;
import com.example.recipessocialapp.weeklyplan.WeeklyPlanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CreatepostActivity extends AppCompatActivity {

    private ActivityCreatepostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreatepostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton backB = findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        View submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(
                        CreatepostActivity.this,
                        "Recipe "+"\""+((EditText)findViewById(R.id.Title)).getText()+"\""+" added succesfully to your profile!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.difficulty_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner pspinner = (Spinner) findViewById(R.id.portions_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.portions_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pspinner.setAdapter(adapter2);

        Spinner wtspinner = (Spinner) findViewById(R.id.working_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.time, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wtspinner.setAdapter(adapter3);

        Spinner ttspinner = (Spinner) findViewById(R.id.total_spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.time, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ttspinner.setAdapter(adapter4);

        LinearLayout custom = (LinearLayout) findViewById(R.id.custom);

        ImageView plusB = findViewById(R.id.moreIngredients);
        plusB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayout ly = new LinearLayout(getApplicationContext());
                ly.setOrientation(LinearLayout.HORIZONTAL);
                ly.setWeightSum(100);

                TextView ingredient = new TextView(getApplicationContext());
                ingredient.setWidth(500);
                ingredient.setTextSize(16);
                ingredient.setHeight(140);
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

        LinearLayout custom2 = (LinearLayout) findViewById(R.id.custom2);

        ImageView plusB2 = findViewById(R.id.moreTags);
        plusB2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayout ly = new LinearLayout(getApplicationContext());
                ly.setOrientation(LinearLayout.HORIZONTAL);
                ly.setWeightSum(100);

                TextView tag = new TextView(getApplicationContext());
                tag.setWidth(500);
                tag.setTextSize(16);
                tag.setHeight(140);
                EditText typed_tag = findViewById(R.id.TypedTag);
                tag.setText("#" + typed_tag.getText());

                ly.addView(tag);

                custom2.addView(ly);
            }
        });




        //bottom bar
        BottomNavigationView bottom_bar = findViewById(R.id.bottom_bar);
        bottom_bar.setSelectedItemId(R.id.navigation_addrecipe);

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
