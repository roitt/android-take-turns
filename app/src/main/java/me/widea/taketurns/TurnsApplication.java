package me.widea.taketurns;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Rohit and Viveka on 12/1/14.
 */
public class TurnsApplication extends Application {

    public static String TAG = "Turns Baby";
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, getResources().getString(R.string.parse_app_id), getResources().getString(R.string.parse_client_key));

    }
}
