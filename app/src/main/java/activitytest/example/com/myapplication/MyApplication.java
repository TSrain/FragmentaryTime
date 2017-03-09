package activitytest.example.com.myapplication;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by lawrence on 2017/3/8.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
