package com.example.devin.devin_volleyimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class MainActivity extends AppCompatActivity {

    NetworkImageView networkImageView;


    ImageLoader imageLoader;

    String IMAGE_URL2 = "http://developer.android.com/images/training/system-ui.png";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //RequestQueue queue = MySingleTon.getInstance(this).getRequestQueue();
        imageLoader = MySingleTon.getInstance(this).getImageLoader();


        networkImageView = (NetworkImageView) findViewById(R.id.volley_networkImageView);
        networkImageView.setImageUrl(IMAGE_URL2, imageLoader);

    }


}
