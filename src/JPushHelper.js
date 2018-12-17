/**
 * Created by Niki on 2018/12/14 12:18.
 * Email: m13296644326@163.com
 */

import React from 'react';
import {
    Platform,
    NativeModules
} from 'react-native';
const {IntentModule} = NativeModules;
const isIos = Platform.OS === 'ios';
export default {
    getExtras: () => {
        if (isIos){
            return;
        }
        return IntentModule.getExtras();
    }
}
