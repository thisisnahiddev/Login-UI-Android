package com.ezmico.loginui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ezmico.loginui.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    String email;
    String getpassword;


    // @thisismd.nahid on Instagram
    // thisisnahiddev on GitHub



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));


            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = binding.emailAddress.getText().toString().trim().toLowerCase();
                getpassword = binding.password.getText().toString();

                if (email.isEmpty() && getpassword.isEmpty()) {

                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Alert")
                            .setIcon(R.drawable.alert)
                            .setMessage("Please Enter Your Email & password")
                            .show();

                } else if (email.length() > 0 && getpassword.length() > 0) {

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                }


            }
        });
        binding.google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Google", Toast.LENGTH_SHORT).show();
            }
        });
        binding.apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Apple", Toast.LENGTH_SHORT).show();
            }
        });


    }
}