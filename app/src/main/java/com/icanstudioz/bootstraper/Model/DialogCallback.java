package com.icanstudioz.bootstraper.Model;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.icanstudioz.bootstraper.App;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.request.base.Request;

public abstract class DialogCallback<T> extends AbsCallback<T> {

    SVProgressHUD hud = null;
    boolean isDialog=true;

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        super.onStart(request);
        if (hud != null) {
            hud.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Black);
        }
    }

    public DialogCallback(Activity activity) {
        super();
        hud = App.getInstance().showProgress(activity, "Loading...");
    }

    public DialogCallback(Activity activity, boolean isDialog) {
        super();
        this.isDialog = isDialog;
        if (isDialog)
            hud = App.getInstance().showProgress(activity, "Loading...");
    }

    @Override
    public void onFinish() {
        super.onFinish();
        if (isDialog)
            hud.dismiss();
    }
}