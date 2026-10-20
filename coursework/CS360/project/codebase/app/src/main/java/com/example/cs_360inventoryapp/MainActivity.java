package com.example.cs_360inventoryapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent activity_database = new Intent(MainActivity.this, ActivityDB.class);
        Intent activity_sms = new Intent(MainActivity.this, ActivitySMS.class);
        Intent activity_newuser = new Intent(MainActivity.this, NewUser.class);
        dbinterface db = new dbinterface(MainActivity.this);

        // Pseudo Test harness for different activities
          // startActivity(activity_database);
          // startActivity(activity_sms);
        // End pseudo test harness

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonLogin = findViewById(R.id.button_login);

        EditText inputUsername = findViewById(R.id.EditText_username);
        EditText inputPassword = findViewById(R.id.EditText_Password);
        TextView loginErrorText = findViewById(R.id.activitymain_error);

        Button buttonNewUser = findViewById(R.id.button_create_new_account);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                boolean validLogin = db.isValidLogin(
                        inputUsername.getText().toString(),
                        inputPassword.getText().toString()
                );

                if (validLogin) {
                    loginErrorText.setText("");
                    startActivity(activity_database);
                }
                else {
                    loginErrorText.setText("Error: Invalid username or password");
                }
            }
        });

        buttonNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activity_newuser);
            }
        });
    }
}

/*
 * References
 *
 */
