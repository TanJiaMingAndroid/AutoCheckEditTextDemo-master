package com.tanjiaming.www.biz;

/**
 * Created by 39481 on 2018/3/12.
 */

public interface IUserBiz {
    public void login(String username,String password,OnLoginLisener onLoginLisener);
}
