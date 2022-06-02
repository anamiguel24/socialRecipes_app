package com.example.recipessocialapp.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.databinding.ActivityMysettingsBinding;

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
    }
}

