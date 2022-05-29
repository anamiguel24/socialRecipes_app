package com.example.recipessocialapp.search;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.createpost.CreatepostActivity;
import com.example.recipessocialapp.feed.FeedActivity;
import com.example.recipessocialapp.feed.PostActvity;
import com.example.recipessocialapp.feed.PostActvity2;
import com.example.recipessocialapp.feed.PostActvity3;
import com.example.recipessocialapp.feed.PostActvity4;
import com.example.recipessocialapp.profilePages.MyProfileActivity;
import com.example.recipessocialapp.profilePages.UserProfileActivity;
import com.example.recipessocialapp.shoppinglist.ShoppingListActivity;
import com.example.recipessocialapp.weeklyplan.WeeklyPlanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipesActivity extends AppCompatActivity implements Adapter.ItemClickListener {
    private Adapter adapter;
    private List<Item> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchrecipes);
        fillList();
        setUpRecyclerView();

        SearchView searchView =findViewById(R.id.searchView);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        BottomNavigationView bb = findViewById(R.id.bottom_bar);
        bb.getMenu().setGroupCheckable(0, false, true);

        bb.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
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

    private void fillList() {
        List = new ArrayList<>();
        List.add(new Item(R.drawable.pizza2, "Mozzarella Pizza","@jennifer21", "#mozzarella #Italian"));
        List.add(new Item(R.drawable.sushi1, "Sushi", "@noahflower","#Rice #Asian #SeaWeed"));
        List.add(new Item(R.drawable.pasta, "Shrimp Pasta","@emily1miller", "#Shrimp #Fish #Italian"));
        List.add(new Item(R.drawable.salmon, "Oven-baked Salmon with spices","@noahflower", "#Fish #Asian"));
        List.add(new Item(R.drawable.hamburger, "Hamburger","@noahflower", "#Meat #Lettuce"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(List, this::selectedItem);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void selectedItem(Item item) {
        String recipe = item.getText1();
        switch (recipe){
            case "Sushi":
                startActivity(new Intent(SearchRecipesActivity.this,  PostActvity.class));
                break;
            case "Mozzarella Pizza":
                startActivity(new Intent(SearchRecipesActivity.this,  PostActvity2.class));
                break;
            case "Shrimp Pasta":
                startActivity(new Intent(SearchRecipesActivity.this,  PostActvity3.class));
                break;
            case "Oven-baked Salmon with spices":
                startActivity(new Intent(SearchRecipesActivity.this,  PostActvity4.class));
                break;
            case "Hamburger":
                startActivity(new Intent(SearchRecipesActivity.this,  PostActvity4.class));
                break;
            default:
                startActivity(new Intent(SearchRecipesActivity.this,  PostActvity4.class));
        }

    }
}