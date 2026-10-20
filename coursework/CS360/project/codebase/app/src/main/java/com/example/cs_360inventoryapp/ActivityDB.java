package com.example.cs_360inventoryapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ActivityDB extends AppCompatActivity {

    TableLayout inventoryTable;
    TableRow.LayoutParams cellParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_database);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inventoryTable = findViewById(R.id.tableLayout_inventory);
        cellParams = new TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f
        );

        RenderHeader();
        FillTable();

        Intent activityNewItem = new Intent(ActivityDB.this, NewItem.class);
        FloatingActionButton fabAddNewItem = findViewById(R.id.inventory_fab_new);
        fabAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activityNewItem);
            }
        });

        FloatingActionButton fabRefreshScreen = findViewById(R.id.inventory_fab_refresh);
        fabRefreshScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryTable.removeAllViews();
                RenderHeader();
                FillTable();
            }
        });
    }

    void RenderHeader() {
        // Main header

        // The "TableRows", "TextViews" and "Button" were heavily assisted with Google's
        //  AI overview, drawing heavily from [1][2][6][7][8]
        TableRow mainHeader = new TableRow(ActivityDB.this);
        TextView mainHeaderTextView = new TextView(ActivityDB.this);
        mainHeaderTextView.setText("Inventory Listing");
        mainHeaderTextView.setGravity(Gravity.LEFT);
        mainHeaderTextView.setTextSize(30f);
        mainHeaderTextView.setPadding(25, 25, 25, 25);
        mainHeaderTextView.setLayoutParams(cellParams);
        mainHeader.addView(mainHeaderTextView);
        inventoryTable.addView(mainHeader);

        // Add feature labels,
        TableRow featureLabels = new TableRow(ActivityDB.this);

        TextView colName = new TextView(ActivityDB.this);
        colName.setText("Name");
        //colName.setGravity(Gravity.LEFT);
        colName.setTypeface(null, Typeface.BOLD);
        colName.setPadding(10, 10, 10, 10);
        colName.setLayoutParams(cellParams);
        featureLabels.addView(colName);

        TextView colCat = new TextView(ActivityDB.this);
        colCat.setText("Category");
        //colCat.setGravity(Gravity.LEFT);
        colCat.setTypeface(null, Typeface.BOLD);
        colCat.setPadding(10, 10, 10, 10);
        colCat.setLayoutParams(cellParams);
        featureLabels.addView(colCat);

        TextView colDesc = new TextView(ActivityDB.this);
        colDesc.setText("Description");
        //colDesc.setGravity(Gravity.LEFT);
        colDesc.setTypeface(null, Typeface.BOLD);
        colDesc.setPadding(10, 10, 10, 10);
        colDesc.setLayoutParams(cellParams);
        featureLabels.addView(colDesc);

        TextView colRemove = new TextView(ActivityDB.this);
        colRemove.setText("Remove Item");
        colRemove.setTypeface(null, Typeface.BOLD);
        colRemove.setPadding(0, 10, 25, 10);
        colRemove.setLayoutParams(cellParams);
        featureLabels.addView(colRemove);

        inventoryTable.addView(featureLabels);
    }

    void FillTable() {
        dbinterface db = new dbinterface(ActivityDB.this);

        List<List<String>> inventoryTabular = db.getInventory();

        for (List<String> row : inventoryTabular) {
            TableRow item = new TableRow(ActivityDB.this);
            item.setLayoutParams(new TableLayout.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            String curName = row.get(0);
            TextView colCurName = new TextView(ActivityDB.this);
            colCurName.setText(curName);
            colCurName.setPadding(25, 10, 0, 10);
            colCurName.setLayoutParams(cellParams);
            item.addView(colCurName);

            String curCat = row.get(1);
            TextView colCurCat = new TextView(ActivityDB.this);
            colCurCat.setText(curCat);
            colCurCat.setPadding(10, 10, 10, 10);
            colCurCat.setLayoutParams(cellParams);
            item.addView(colCurCat);

            String curDesc = row.get(2);
            TextView colCurDesc = new TextView(ActivityDB.this);
            colCurDesc.setText(curDesc);
            colCurDesc.setPadding(0, 10, 25, 10);
            colCurDesc.setLayoutParams(cellParams);
            item.addView(colCurDesc);

            // Add the remove button
            Button currentRemover = new Button(this);
            currentRemover.setText("X");
            currentRemover.setGravity(Gravity.START);
            currentRemover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String rowDelete = row.get(3);
                    db.deleteItem(rowDelete);
                    inventoryTable.removeView(item);
                }
            });
            item.addView(currentRemover);

            inventoryTable.addView(item);
        }
    }
}

/*
 * References
 * 1. API Reference (n.d.). Add buttons to your app. Android Developers. Retrieved on Oct. 15, 2026 from:
 *   https://developer.android.com/develop/ui/views/components/button
 * 2. Tutorial's Point (n.d.). How to add table rows Dynamically in Android Layout?. Retrieved on Oct. 15,
 *   2026 from: https://www.tutorialspoint.com/article/how-to-add-table-rows-dynamically-in-android-layout
 * 3. "iCode Consultancy" (Jan. 23, 2022). How to display data in a table in android studio. Retrieved on
 *   Oct. 17, 2026 from: https://www.youtube.com/watch?v=DQOUkG4-gsE
 * 4. Android Developers (n.d.). Add a floating action button. Retrieved on Oct. 17, 2026 from:
 *   https://developer.android.com/develop/ui/views/components/floating-action-button#java
 * 5. TUT. ID (Dec 10, 2022).  Android Studio - Populate TableLayout Java (Fast Tutorial). Retrieved on Oct.
 *   18, 2026 from: https://www.youtube.com/watch?v=vDyyj4Z4Q5g
 * 6. "Chosen1" (May 10, 2016). Android - TableRow column alignment programmatically. StackOverflow. Retr-
 *   -ieved on Oct 18, 2026 from:
 *   https://stackoverflow.com/questions/37134443/android-tablerow-column-alignment-programmatically
 * 7. "Yan" (Nov. 25, 2022). How to set font weight programmatically?. StackOverflow. Retrieved on Oct. 18,
 *   2026 from: https://stackoverflow.com/questions/74570393/how-to-set-font-weight-programmatically
 * 8. "user1497577" (Jul. 5, 2022). Left align text inside a button in Android. StackOverflow. Retrieved on Oct.
 *   19, 2026 from: https://stackoverflow.com/questions/11337513/left-align-text-inside-a-button-in-android
 * 9. "coder" (Oct. 27, 2011). button text not getting centered vertically in button. StackOverflow. Retrieved
 *   on Oct. 19, 2026 from: https://stackoverflow.com/questions/7922038/button-text-not-getting-centered-vertically-in-button
 * 10. Mustafa, E. (Jan. 23, 2014). Android delete button. StackOverflow. Retrieved on Oct. 19, 2026 from:
 *   https://stackoverflow.com/questions/21316379/android-delete-button
 * 11. Vallery, S. (Nov. 18, 2021).  When using Java to program an Android TableLayout, how do I adjust the Views
 *   within the TableRows?. Code Ranch Forums. Retrieved on Oct. 19, 2026 from:
 *   https://coderanch.com/t/747165/Java-program-Android-TableLayout-adjust
 * 12. Android Developers (n.d.). Table. Retrieved on Oct. 19, 2026 from:
 *   https://developer.android.com/guide/topics/ui/layout/grid
 */
