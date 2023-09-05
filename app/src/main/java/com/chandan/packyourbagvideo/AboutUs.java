package com.chandan.packyourbagvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    ImageView imgYoutube, imgInstagram, imgTwitter;
    TextView txtEmail, txtWebsiteUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About us");

        imgYoutube = findViewById(R.id.imgYoutube);
        txtEmail = findViewById(R.id.txtEmail);
        txtWebsiteUrl = findViewById(R.id.txtWebsiteUrl);
        imgInstagram = findViewById(R.id.imgInstagram);
        imgTwitter = findViewById(R.id.imgTwitter);

        imgYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToUrl("https://www.youtube.com");
            }
        });

        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "www.avitcollege.ac@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "From Back Your Bag");
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    System.out.println(e);
                }

            }
        });

        txtWebsiteUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToUrl("https://www.pwskills.com");
            }
        });

        imgInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToUrl("https://instagram.com");
            }
        });

        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToUrl("https://www.twitter.com");
            }
        });

    }

    private void navigateToUrl(String url){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}