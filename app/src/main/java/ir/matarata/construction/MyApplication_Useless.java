package ir.matarata.construction;
//Useless for now
import android.app.Application;
import android.content.Context;

/**
 * Created by Matarata on 6/16/2016.
 */
public class MyApplication_Useless extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication_Useless.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication_Useless.context;
    }
}
