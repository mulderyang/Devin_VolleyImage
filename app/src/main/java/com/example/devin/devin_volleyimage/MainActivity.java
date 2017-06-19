package com.example.devin.devin_volleyimage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;

public class MainActivity extends AppCompatActivity {

    NetworkImageView networkImageView;
    ImageView imageView;


    ImageLoader imageLoader;

    String IMAGE_URL2 = "http://developer.android.com/images/training/system-ui.png";
    String imgurl = "http://www.google.co.kr/logos/doodles/2014/anna-freuds-119th-birthday-5664856720015360-hp.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //RequestQueue queue = MySingleTon.getInstance(this).getRequestQueue();
        imageLoader = MySingleTon.getInstance(this).getImageLoader();


        networkImageView = (NetworkImageView) findViewById(R.id.volley_networkImageView);
        networkImageView.setImageUrl(IMAGE_URL2, imageLoader);

        imageView = (ImageView) findViewById(R.id.volley_imageRequest);

        ImageRequest imageRequest = new ImageRequest(imgurl, listener, 0, 0, Bitmap.Config.ARGB_8888, errorListener);
        MySingleTon.getInstance(this).addToRequestQueue(imageRequest);

    }




    Response.Listener<Bitmap> listener = new Response.Listener<Bitmap>() {
        @Override
        public void onResponse(Bitmap response) {
            imageView.setImageBitmap(response);

        }
    };


    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };


}
