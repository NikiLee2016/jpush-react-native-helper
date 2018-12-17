package com.niki.jpush;

import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ParseUtil {
    public static JSONObject formatBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Bundle mBundle = new Bundle();
        JSONObject bundleJson = JSON.parseObject(JSON.toJSONString(bundle));
        JSONObject map = bundleJson.getJSONObject("map");
        if (map == null) {
            return null;
        }
        return map;
    }
}