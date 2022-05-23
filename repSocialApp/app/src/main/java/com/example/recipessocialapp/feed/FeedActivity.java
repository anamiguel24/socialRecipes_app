package com.example.recipessocialapp.feed;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.example.recipessocialapp.databinding.ActivityFeedBinding;


public class FeedActivity extends AppCompatActivity {
    private ActivityFeedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}
