/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import java.util.Date;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.tutelatechnologies.sdk.framework.TUe;
import com.tutelatechnologies.sdk.framework.TutelaSDK;
import com.tutelatechnologies.sdk.framework.TutelaSDKFactory;
import com.tutelatechnologies.sdk.framework.TutelaSDKService;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class MiPlugin extends CordovaPlugin {
  private static final String TAG = "MiPlugin";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Inicializando MiPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("saludar")) {
      // An example of returning data back to the web layer
       String phrase = args.getString(0);
      // Echo back the first argument      
      final PluginResult result = new PluginResult(PluginResult.Status.OK, "Hola todo el... "+phrase);
      callbackContext.sendPluginResult(result);
    }
    return true;
  }
/*
  String api_key = "unf79ci2coafe9utuu2hvgr2c4";

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter(TutelaSDK.INITIALIZATION_COMPLETE_ACTION);
        TutelaSDKFactory.getTheSDK().registerReceiver(this.getApplicationContext(), initializationReceiver, intentFilter);


        try {
            System.out.println("Entra a My Applicationnn");
            TutelaSDKFactory.getTheSDK().initializeWithApiKey(api_key, this);
            setID.execute();
        } catch (Exception e) {
            // Handle the Tutela SDK failing to initialize.
            e.printStackTrace();
        }
    }

    private final BroadcastReceiver initializationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("Entra a initialize");
            try {
                if (intent.getBooleanExtra(TutelaSDK.INITIALIZATION_COMPLETE_EXTRA, false)) {
                    System.out.println("TutelaAnalyticService"+"Tutela SDK successfully initialized.");
                    System.out.println("BATTERY_SERVICE: " + TutelaSDKService.BATTERY_SERVICE);
                    System.out.println("CONNECTIVITY_SERVICE: " + TutelaSDKService.CONNECTIVITY_SERVICE);
                    System.out.println("TRIM_MEMORY_COMPLETE: " + TutelaSDKService.TRIM_MEMORY_COMPLETE);

                } else {
                    System.out.println("TutelaAnalyticService"+ "Tutela SDK not successfully initialized.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            TutelaSDKFactory.getTheSDK().unRegisterReceiver(getApplicationContext(), initializationReceiver);
        }
    };

    AsyncTask<Void, Void, String> setID = new AsyncTask<Void, Void, String>() {
        @Override
        protected String doInBackground(Void... params) {
            String aaid = "NA";
            System.out.println("Valor"+ aaid);
            try {
                com.google.android.gms.ads.identifier.AdvertisingIdClient.Info adInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
                System.out.println("adInfo"+ adInfo);
                if (adInfo != null) {
                    if(!adInfo.isLimitAdTrackingEnabled()) {
                        aaid = adInfo.getId();

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return aaid;
        }

        @Override
        protected void onPostExecute(String aaid) {
            System.out.println("aaid"+aaid);
            TutelaSDKFactory.getTheSDK().setAaid(aaid, getApplicationContext());
        }

    };
*/
}
