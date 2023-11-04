package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DBHelper helper;
    private SQLiteDatabase database;

    private ListView listView;
    private Button foodCategoryBtn, clothesCategoryBtn, toysCategoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodCategoryBtn = findViewById(R.id.foodCategoryBtn);
        clothesCategoryBtn = findViewById(R.id.clothesCategoryBtn);
        toysCategoryBtn = findViewById(R.id.toysCategoryBtn);

        helper = new DBHelper(getApplicationContext());
        try {
            database = helper.getWritableDatabase();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        foodCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> products = new ArrayList<>();
                HashMap<String, String> product;

                Cursor cursor = database.rawQuery("SELECT * FROM products WHERE categoryId = 1", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    product = new HashMap<>();
                    product.put("productName", cursor.getString(1));
                    product.put("productInfo", "price: " + cursor.getString(3) + "\ndescription: " + cursor.getString((2)));
                    products.add(product);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        products,
                        android.R.layout.simple_list_item_2,
                        new String[]{"productName", "productInfo"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );

                listView.setAdapter(adapter);
            }
        });

        clothesCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> products = new ArrayList<>();
                HashMap<String, String> product;

                Cursor cursor = database.rawQuery("SELECT * FROM products WHERE categoryId = 2", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    product = new HashMap<>();
                    product.put("productName", cursor.getString(1));
                    product.put("productInfo", "price: " + cursor.getString(3) + "\ndescription: " + cursor.getString((2)));
                    products.add(product);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        products,
                        android.R.layout.simple_list_item_2,
                        new String[]{"productName", "productInfo"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );

                listView.setAdapter(adapter);
            }
        });

        toysCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> products = new ArrayList<>();
                HashMap<String, String> product;

                Cursor cursor = database.rawQuery("SELECT * FROM products WHERE categoryId = 3", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    product = new HashMap<>();
                    product.put("productName", cursor.getString(1));
                    product.put("productInfo", "price: " + cursor.getString(3) + "\ndescription: " + cursor.getString((2)));
                    products.add(product);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        products,
                        android.R.layout.simple_list_item_2,
                        new String[]{"productName", "productInfo"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );

                listView.setAdapter(adapter);
            }
        });
    }
}