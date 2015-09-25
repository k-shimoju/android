package test.volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import android.app.Application;

/**
 * Created by shimoju_k on 2015/09/25.
 */
public class AppController extends Application {

    public RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
    }
}
