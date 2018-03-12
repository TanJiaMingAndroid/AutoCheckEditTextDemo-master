package com.tanjiaming.www.biz;

import com.tanjiaming.www.bean.User;

/**
 * Created by 39481 on 2018/3/12.
 */

public class UserBiz implements IUserBiz{

    @Override
    public void login(final String username, final String password, final OnLoginLisener onLoginLisener) {
        new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                if ("zhangsan".equals(username)&&"123".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginLisener.loginSuccess(user);
                }
                else {
                    onLoginLisener.loginFaile();
                }
            }
        }.start();
    }
}
