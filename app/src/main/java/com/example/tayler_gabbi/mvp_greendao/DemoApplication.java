package com.example.tayler_gabbi.mvp_greendao;

import android.app.Application;


import com.example.tayler_gabbi.mvp_greendao.database.DaoMaster;
import com.example.tayler_gabbi.mvp_greendao.database.DaoSession;

import org.greenrobot.greendao.database.Database;

public class DemoApplication extends Application{

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"mydb");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
