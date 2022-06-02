package com.example.recipessocialapp.shoppinglist;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Paint;
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
    private int oiltaps=0;
    private int tomatotaps=0;
    private int salttaps=0;
    private int sugartaps=0;
    private int pumpkintaps=0;
    private int eggtaps=0;

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

        CheckBox oil = findViewById(R.id.oil);
        TextView u1 = findViewById(R.id.u1);
        oil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(oiltaps%2==0) {
                    oil.setPaintFlags(oil.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    u1.setPaintFlags(u1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else {
                    oil.setPaintFlags(oil.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    u1.setPaintFlags(u1.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
                oiltaps++;
            }
        });

        CheckBox tomato = findViewById(R.id.tomato);
        TextView u2 = findViewById(R.id.u2);
        tomato.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(tomatotaps%2==0) {
                    tomato.setPaintFlags(tomato.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    u2.setPaintFlags(u2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else {
                    tomato.setPaintFlags(tomato.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    u2.setPaintFlags(u2.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
                tomatotaps++;
            }
        });

        CheckBox salt = findViewById(R.id.salt);
        TextView u3 = findViewById(R.id.u3);
        salt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(salttaps%2==0) {
                    salt.setPaintFlags(salt.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    u3.setPaintFlags(u3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else {
                    salt.setPaintFlags(salt.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    u3.setPaintFlags(u3.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
                salttaps++;
            }
        });

        CheckBox sugar = findViewById(R.id.sugar);
        TextView u4 = findViewById(R.id.u4);
        sugar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(sugartaps%2==0) {
                    sugar.setPaintFlags(sugar.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    u4.setPaintFlags(u4.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else {
                    sugar.setPaintFlags(sugar.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    u4.setPaintFlags(u4.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
                sugartaps++;
            }
        });

        CheckBox pumpkin = findViewById(R.id.pumpkin);
        TextView u5 = findViewById(R.id.u5);
        pumpkin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(pumpkintaps%2==0) {
                    pumpkin.setPaintFlags(pumpkin.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    u5.setPaintFlags(u5.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else {
                    pumpkin.setPaintFlags(pumpkin.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    u5.setPaintFlags(u5.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
                pumpkintaps++;
            }
        });

        CheckBox egg = findViewById(R.id.egg);
        TextView u6 = findViewById(R.id.u6);
        egg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(eggtaps%2==0) {
                    egg.setPaintFlags(egg.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    u6.setPaintFlags(u6.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else {
                    egg.setPaintFlags(egg.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    u6.setPaintFlags(u6.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
                eggtaps++;
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
