package test.volley_imageloader;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import android.app.Application;
import android.graphics.Bitmap;

/**
 * Created by shimoju_k on 2015/09/25.
 */
public class AppController extends Application {

    public RequestQueue mRequestQueue;
    public ImageLoader mImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mImageLoader = new ImageLoader(mRequestQueue, new LruBitmapCache(getApplicationContext()));
    }
}
