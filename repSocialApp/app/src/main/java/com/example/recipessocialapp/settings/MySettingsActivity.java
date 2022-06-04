package com.example.recipessocialapp.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.databinding.ActivityMysettingsBinding;
import com.example.recipessocialapp.login.LoginActivity;
import com.example.recipessocialapp.profilePages.MyProfileActivity;

public class MySettingsActivity extends AppCompatActivity {
    private ActivityMysettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = ActivityMysettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton backB =findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        View signoutB =findViewById(R.id.b_signOut);
        signoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MySettingsActivity.this,  LoginActivity.class));
            }
        });
    }
}

