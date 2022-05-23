package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {

    EditText username;
    EditText email;
    EditText pass1;
    EditText pass2;
    Button signup;
    float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        username = root.findViewById(R.id.username);
        email = root.findViewById(R.id.email);
        pass1 = root.findViewById(R.id.pass1);
        pass2 = root.findViewById(R.id.pass2);
        signup = root.findViewById(R.id.button);

        email.setTranslationX(800);
        username.setTranslationX(800);
        pass1.setTranslationX(800);
        pass2.setTranslationX(800);
        signup.setTranslationX(800);

        username.setAlpha(v);
        email.setAlpha(v);
        pass1.setAlpha(v);
        pass2.setAlpha(v);
        signup.setAlpha(v);

        username.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass1.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        pass2.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}
