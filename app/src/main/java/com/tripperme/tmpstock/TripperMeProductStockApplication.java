package com.tripperme.tmpstock;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.tripperme.tmpstock.util.Constants;

/**
 * Created by karthik on 2/5/17.
 */

public class TripperMeProductStockApplication extends MultiDexApplication {

    private static TripperMeProductStockApplication mInstance;

    public static synchronized TripperMeProductStockApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(Constants.PARSE_APP_ID)
                .clientKey(Constants.PARSE_CLIENT_ID)
                .server(Constants.PARSE_SERVER).build()
        );

        ParseUser.enableRevocableSessionInBackground();
        ParseACL defaultACL = new ParseACL();

        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

        final ParseInstallation parseInstallation = ParseInstallation.getCurrentInstallation();
        parseInstallation.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.d("PARSE::INSTALL","Parse device registration successfully.");
            }
        });
    }
}
