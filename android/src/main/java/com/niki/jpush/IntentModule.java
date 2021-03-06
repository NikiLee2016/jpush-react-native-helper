package com.niki.jpush;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

public class IntentModule extends ReactContextBaseJavaModule {
    public IntentModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void getExtras(Promise promise){
        Log.i("IntentModule.log", "getExtras");
        Activity activity = getCurrentActivity();
        if (activity != null){
            Intent intent = activity.getIntent();
            if (intent != null){
                Bundle extras = intent.getExtras();
                if (extras != null){
                    WritableMap writableMap = Arguments.fromBundle(extras);
                    promise.resolve(writableMap);
                }else {
                    //promise.reject("1", "extras is null");
                }
            }else {
                promise.reject("1", "intent is null");
            }
        }else {
            promise.reject("1", "getCurrentActivity is null");
        }
    }

    @Override
    public String getName() {
        return "IntentModule";
    }
}
