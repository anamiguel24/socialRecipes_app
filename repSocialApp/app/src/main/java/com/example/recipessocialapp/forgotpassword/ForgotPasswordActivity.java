package com.example.recipessocialapp.forgotpassword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipessocialapp.R;
import com.example.recipessocialapp.databinding.ActivityFeedBinding;
import com.example.recipessocialapp.databinding.ActivityForgotpasswordBinding;
import com.example.recipessocialapp.feed.FeedActivity;
import com.example.recipessocialapp.login.LoginActivity;


public class ForgotPasswordActivity extends AppCompatActivity {
    private ActivityForgotpasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForgotpasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
            }
        });


    }
}
