package com.icanstudioz.bootstraper;

import android.app.Application;
import android.content.Context;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.google.gson.Gson;
import com.icanstudioz.bootstraper.Model.User;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpParams;

import java.util.logging.Level;

import okhttp3.OkHttpClient;

public class App extends Application {
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        goInit();
        app=this;
    }

    public void goInit() {
        OkGo.getInstance().init(this);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(" Ep ");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        OkGo.getInstance().setOkHttpClient(builder.build());

    }

    public static App getInstance() {
        if(app==null){
            app=new App();
        }
        return app;

    }

    public SVProgressHUD showProgress(Context c,String s){
        SVProgressHUD hud=new SVProgressHUD(c);
        hud.setText(s);
        return hud;
    }


    public void saveUser(User body) {
        TinyDB db=new TinyDB(this);
        db.putString("user",new Gson().toJson(body));
        goInit();
    }

    public User getUser(){
        TinyDB db=new TinyDB(this);
        return new Gson().fromJson(db.getString("user"),User.class);
    }

    public void clear() {
        TinyDB db=new TinyDB(this);
        db.clear();
        OkGo.getInstance().getCommonParams().clear();
    }
}
