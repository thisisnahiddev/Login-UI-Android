package com.ezmico.loginui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ezmico.loginui.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;

    String name;
    String email;
    String getpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog setDialog = new Dialog(SignUpActivity.this);
                setDialog.setContentView(R.layout.custom_dialog_thankyou);


                TextView buttonHome = setDialog.findViewById(R.id.buttonHome);

                name = binding.nameEd.getText().toString().trim();
                email = binding.emailAddress.getText().toString().trim().toLowerCase();
                getpassword = binding.password.getText().toString();

                if (name.isEmpty() && email.isEmpty() && getpassword.isEmpty()) {

                    new AlertDialog.Builder(SignUpActivity.this)
                            .setTitle("Alert")
                            .setIcon(R.drawable.alert)
                            .setMessage("Please Enter Your Email & password")
                            .show();

                } else if (name.length() >0 && email.length() >0 && getpassword.length() >0){

                    buttonHome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(SignUpActivity.this,HomeActivity.class));

                        }
                    });
                    setDialog.show();
                    //Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    //startActivity(intent);

                }


            }
        });
        binding.google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this,"Google",Toast.LENGTH_SHORT).show();
            }
        });
        binding.apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this,"Apple",Toast.LENGTH_SHORT).show();
            }
        });





    }
}