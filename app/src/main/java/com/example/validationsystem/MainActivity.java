package com.example.validationsystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputEmail;

    EditText inputPassword;

    EditText inputPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.registerBtn);

        btn.setOnClickListener(v -> onRegisterButtonClick());

        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        inputPasswordConfirm = findViewById(R.id.input_password_confirmation);
    }

    public void onRegisterButtonClick() {
        ValidationPatterns validationPatterns = new ValidationPatterns();

        String strEmail = inputEmail.getText().toString();
        String strPassword = inputPassword.getText().toString();
        String strPasswordConfirm = inputPasswordConfirm.getText().toString();

        User registering = new User(strEmail, strPassword, strPasswordConfirm);

        if (validationPatterns.validateEmail(registering)) Toast.makeText(getApplicationContext(),
                "User can be registered", Toast.LENGTH_SHORT).show();

        else Toast.makeText(getApplicationContext(),
                "user can not be registered", Toast.LENGTH_SHORT).show();
    }
}