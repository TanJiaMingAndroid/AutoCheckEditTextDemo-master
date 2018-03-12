package com.tanjiaming.www.biz;

import com.tanjiaming.www.bean.User;

/**
 * Created by 39481 on 2018/3/12.
 */

public interface OnLoginLisener {
    public void loginSuccess(User user);
    public void loginFaile();

}
