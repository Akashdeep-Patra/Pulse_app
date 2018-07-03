package com.example.lucifer.pulse_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
   private TextView id,name,category,mrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        id = findViewById(R.id.id_details);
        name=findViewById(R.id.name_details);
        category=findViewById(R.id.category_details);
        mrp=findViewById(R.id.mrp_details);
        id.setText("ID:\n\n" + i.getStringExtra("id"));
        name.setText("NAME:\n\n" + i.getStringExtra("name"));
        category.setText("CATEGORY:\n\n" + i.getStringExtra("category"));
        mrp.setText("MRP:\n\n" + i.getStringExtra("mrp"));
    }
}
