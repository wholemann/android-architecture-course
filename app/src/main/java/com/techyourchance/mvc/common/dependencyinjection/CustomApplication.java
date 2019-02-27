package com.techyourchance.mvc.common.dependencyinjection;

import android.app.Application;

public class CustomApplication extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
