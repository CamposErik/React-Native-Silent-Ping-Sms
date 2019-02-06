/**
 * Copyright Teclib. All rights reserved.
 *
 * React Native Silent Ping SMS is used to send the sms and bring the delivery report.
 * ------------------------------------------------------------------------------
 * Created by yeyintkoko on 11/4/16.
 * @author    Erik Campos
 * @copyright Copyright Teclib. All rights reserved.
 * @version   1.2.0
 * @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
 * @link      https://github.com/CamposErik/React-Native-Silent-Ping-Sms
 * ------------------------------------------------------------------------------
 */

package com.reactlibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;

public class RNSilentPingSmsPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
      List<NativeModule> modules = new ArrayList<>();

      modules.add(new SendSilentSMS(reactContext));

      return modules;
    }

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
      return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Collections.emptyList();
    }
}