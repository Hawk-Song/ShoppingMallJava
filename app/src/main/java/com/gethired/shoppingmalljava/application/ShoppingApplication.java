package com.gethired.shoppingmalljava.application;

import android.app.Application;

public class ShoppingApplication extends Application {

    private static ShoppingApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static ShoppingApplication getInstance() {
        return mApplication;
    }
}
