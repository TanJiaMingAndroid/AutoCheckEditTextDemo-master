package com.tanjiaming.www.presenter;

import com.tanjiaming.www.bean.User;
import com.tanjiaming.www.biz.IUserBiz;
import com.tanjiaming.www.biz.OnLoginLisener;
import com.tanjiaming.www.biz.UserBiz;
import com.tanjiaming.www.view.IUserLoginView;

import java.util.logging.Handler;

/**
 * Created by 39481 on 2018/3/12.
 */

public class UserLoginPresenter {
    private IUserBiz iUserBiz;
    private IUserLoginView iUserLoginView;
    private android.os.Handler handler = new android.os.Handler();
    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.iUserLoginView = userLoginView;
        this.iUserBiz = new UserBiz();
    }

    public void login(){
        iUserLoginView.showLoading();
        iUserBiz.login(iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginLisener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFaile() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.showFailedError();
                        iUserLoginView.hideLoading();
                    }
                });

            }
        });
    }


    public void clear()
    {
        iUserLoginView.clearUserName();
        iUserLoginView.clearPassword();
    }
}
