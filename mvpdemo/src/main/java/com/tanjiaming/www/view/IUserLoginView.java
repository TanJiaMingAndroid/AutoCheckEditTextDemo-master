package com.tanjiaming.www.view;

import com.tanjiaming.www.bean.User;

/**
 * Created by 39481 on 2018/3/12.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
