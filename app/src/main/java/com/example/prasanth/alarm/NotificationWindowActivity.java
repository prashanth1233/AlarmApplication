package com.example.prasanth.alarm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class NotificationWindowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ImageView image=(ImageView)findViewById(R.id.sampleImage);
        image.setBackgroundResource(R.drawable.download);
    }
}
