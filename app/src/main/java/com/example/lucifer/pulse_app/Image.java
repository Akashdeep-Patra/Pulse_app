package com.example.lucifer.pulse_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class Image extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent i = getIntent();
        String image = i.getStringExtra("image");
        img = findViewById(R.id.product_image);
        Picasso.get().load(image).placeholder(R.drawable.ic_android_black_24dp).error(R.drawable.ic_android_black_24dp).into(img);

    }
}
