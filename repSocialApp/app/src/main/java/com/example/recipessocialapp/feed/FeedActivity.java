package com.example.recipessocialapp.feed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.recipessocialapp.R;
import com.example.recipessocialapp.databinding.ActivityFeedBinding;
import com.example.recipessocialapp.profilePages.UserProfileActivity;

public class FeedActivity extends AppCompatActivity {
    private ActivityFeedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*View home = findViewById(R.id.navigation_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  FeedActivity.class));
            }
        });*/

        TextView user1 = findViewById(R.id.user1);

        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity.class));
            }
        });

        TextView user2 = findViewById(R.id.user2);
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity.class));
            }
        });

        TextView user3 = findViewById(R.id.user3);
        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedActivity.this,  UserProfileActivity.class));
            }
        });


    }
}
