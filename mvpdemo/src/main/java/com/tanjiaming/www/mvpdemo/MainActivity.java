package com.tanjiaming.www.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tanjiaming.www.bean.User;
import com.tanjiaming.www.presenter.UserLoginPresenter;
import com.tanjiaming.www.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView{
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);

        mBtnClear = (Button) findViewById(R.id.clear);
        mBtnLogin = (Button) findViewById(R.id.login);

        mPbLoading = (ProgressBar) findViewById(R.id.progressbar);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");

    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
