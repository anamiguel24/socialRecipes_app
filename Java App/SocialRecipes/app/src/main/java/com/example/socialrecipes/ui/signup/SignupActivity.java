package com.example.socialrecipes.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.socialrecipes.R;
import com.example.socialrecipes.databinding.ActivitySignupBinding;
import com.example.socialrecipes.ui.feed.FeedActivity;
import com.example.socialrecipes.ui.login.LoginActivity;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button signup_button = (Button) findViewById(R.id.Signup);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, FeedActivity.class));
            }
        });


    }
}
