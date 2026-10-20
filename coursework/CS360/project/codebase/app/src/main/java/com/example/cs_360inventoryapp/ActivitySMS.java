package com.example.cs_360inventoryapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitySMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sms);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView pocReport = findViewById(R.id.label_isSMSpermissions);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 123);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                pocReport.setText("Permissions *NOT* granted");
            }
            else {
                pocReport.setText("Permissions granted");
            }
        }
        else {
            pocReport.setText("Permissions granted");
        }
    }
}

/*
 * References
 * 1. Jee, A. (Sept. 22, 2017). Android SMS Notification Generate. StackOverflow. Retrieved on Oct. 19, 2026 from:
 *   https://stackoverflow.com/questions/46359183/android-sms-notification-generate
 * 2. "Govind" (Oct. 27, 2025). Add Push Notifications in Android The Full Production-Level Guide (with Real
 *   Example). Retrieved on Oct. 19, 2026 from:
 *  https://medium.com/@somgov0/add-push-notifications-in-android-the-full-production-level-guide-with-real-example-bb181bb6c2b0
 */