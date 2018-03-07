package com.example.cmj.autocheckedittextdemo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.cmj.autocheckedittext.AutoCheckEditText;

public class MainActivity extends AppCompatActivity {

    private AutoCheckEditText mobileET;
    private AutoCheckEditText telET;
    private AutoCheckEditText emailET;
    private AutoCheckEditText urlET;
    private AutoCheckEditText chzET;
    private AutoCheckEditText usernameET;
    private AutoCheckEditText inputRegexET;
    private EditText inputET;
    private Drawable successDrable;
    private Drawable unsuccessDrable;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mobileET.creatCheck(AutoCheckEditText.TYPE_OF_MOBILE, successDrable, unsuccessDrable);
        telET.creatCheck(AutoCheckEditText.TYPE_OF_TEL, successDrable, unsuccessDrable);
        emailET.creatCheck(AutoCheckEditText.TYPE_OF_EMAIL, successDrable, unsuccessDrable);
        urlET.creatCheck(AutoCheckEditText.TYPE_OF_URL, successDrable, unsuccessDrable);
        chzET.creatCheck(AutoCheckEditText.TYPE_OF_CHZ, successDrable, unsuccessDrable);
        usernameET.creatCheck(AutoCheckEditText.TYPE_OF_USERNAME, successDrable, unsuccessDrable);
        inputRegexET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    inputRegexET.creatCheck(AutoCheckEditText.TYPE_OF_USER_DEFINE,
                            successDrable, unsuccessDrable,
                            inputET.getText().toString());
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //textView.setText(NetworkUtils.getIPAddress());
                //NetworkUtils.openWirelessSettings();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        Utils.init(getApplication());
        successDrable = ResourcesCompat.getDrawable(getResources(), R.mipmap.success, getApplicationContext().getTheme());
        unsuccessDrable = ResourcesCompat.getDrawable(getResources(), R.mipmap.unsuccess, getApplicationContext().getTheme());
        mobileET = (AutoCheckEditText) findViewById(R.id.et_ac_mobile);
        telET = (AutoCheckEditText) findViewById(R.id.et_ac_tel);
        emailET = (AutoCheckEditText) findViewById(R.id.et_ac_email);
        urlET = (AutoCheckEditText) findViewById(R.id.et_ac_url);
        chzET = (AutoCheckEditText) findViewById(R.id.et_ac_chz);
        usernameET = (AutoCheckEditText) findViewById(R.id.et_ac_username);
        inputET = (EditText) findViewById(R.id.et_ac_input);
        inputRegexET = (AutoCheckEditText) findViewById(R.id.et_ac_input_regex);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textview);
    }
}
