package com.sll.showbiggerimage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import uk.co.senab.photoview.PhotoView;


public class TransitionActivity extends Activity {

    private PhotoView iv_myImageView;
    private String strContentString;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
//        bundle = intent.getExtras();
//        Bitmap bmp = bundle.getParcelable("bitmap");
        iv_myImageView = (PhotoView)findViewById(R.id.iv_myImageView);


        String url = "http://pic19.nipic.com/20120308/4970979_102637717125_2.jpg";
//        Glide.with(this).load(url).into(iv_myImageView);
        Glide.with(this).load(url).placeholder(R.drawable.bg).into(iv_myImageView);

//        Bundle bundle = getIntent().getExtras();
//        strContentString = bundle.getString("imageSrc");
//        iv_myImageView.setImageURL(strContentString);

    }
}
