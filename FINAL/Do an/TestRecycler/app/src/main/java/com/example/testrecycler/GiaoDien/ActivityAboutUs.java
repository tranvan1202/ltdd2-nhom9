package com.example.testrecycler.GiaoDien;


import android.app.Activity;
import android.os.Bundle;

public class ActivityAboutUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        MyHeartShape heart = new MyHeartShape(this);
        setContentView(heart);
    }
}
