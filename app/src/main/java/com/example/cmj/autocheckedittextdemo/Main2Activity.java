package com.example.cmj.autocheckedittextdemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initImage();

    }
  int width = 100;

    private void initImage() {
        imageview = (ImageView)findViewById(R.id.image);
        String url = "http://d.hiphotos.baidu.com/image/pic/item/8601a18b87d6277fcdb9b01d24381f30e924fc68.jpg";
        Glide.with(Main2Activity.this)
                .load(url)
                .crossFade()
                .override(800,800)
                .into(imageview);
    }
}
