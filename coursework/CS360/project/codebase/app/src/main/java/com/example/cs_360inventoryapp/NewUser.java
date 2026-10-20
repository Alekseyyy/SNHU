package com.example.cs_360inventoryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbinterface db = new dbinterface(NewUser.this);

        Button createUser = findViewById(R.id.button_newuser_createuser);
        EditText getNewUser = findViewById(R.id.editTextText_newuser_username);
        EditText getNewPass = findViewById(R.id.editTextTextPassword_newuser_password);
        EditText getConfirm = findViewById(R.id.editTextTextPassword_newuser_confirmpass);
        TextView errorMessage = findViewById(R.id.textView_newuser_error);

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUser = getNewUser.getText().toString();
                String newPass = getNewPass.getText().toString();
                String confirm = getConfirm.getText().toString();
                boolean isUsernameExist = db.isUsernameExist(newUser);

                if (newUser.length() >= 4) {
                    if (newPass.length() >= 8) {
                        if (newPass.equals(confirm)) {
                            if (!db.isUsernameExist(newUser)) {
                                db.insertNewUser(newUser, newPass);
                                errorMessage.setText("");
                                finish();
                            } else {
                                errorMessage.setText("Error: user '" + newUser + "' already exists");
                            }
                        } else {
                            errorMessage.setText("Error: passwords do not match");
                        }
                    } else {
                        errorMessage.setText("Error: password too short");
                    }
                } else {
                    errorMessage.setText("Error: username too short");
                }

            }
        });
    }
}