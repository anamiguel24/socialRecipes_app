package com.example.recipessocialapp.profilePages;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.databinding.ActivityUserprofile1Binding;


public class UserProfileActivity extends AppCompatActivity {
    private ActivityUserprofile1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserprofile1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}
