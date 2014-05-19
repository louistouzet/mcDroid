package com.osiatis.moocandroid;

import android.app.Application;

/**
 * Created by loul on 19/05/14.
 */
public class MoocApplication extends Application {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
