package com.example.cs_360inventoryapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.app.Activity;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewItem extends AppCompatActivity {

    Button addNewItem;
    Button cancelAdd;
    EditText etItemName;
    EditText etItemCat;
    EditText etItemDesc;
    dbinterface db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = new dbinterface(NewItem.this);
        etItemName = findViewById(R.id.editTextText_newitem_name);
        etItemCat = findViewById(R.id.editTextText_newitem_category);
        etItemDesc = findViewById(R.id.editMultiLine_additem_description);

        addNewItem = findViewById(R.id.button_newitem_additem);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertNewItem(
                        etItemName.getText().toString(),
                        etItemCat.getText().toString(),
                        etItemDesc.getText().toString()
                );
                finish();
            }
        });

        cancelAdd = findViewById(R.id.button_newitem_cancel);
        cancelAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}