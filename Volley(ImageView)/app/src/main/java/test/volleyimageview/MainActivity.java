package test.volleyimageview;

import android.app.Activity;
import android.os.Bundle;

import com.android.volley.toolbox.NetworkImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.image_view)
    NetworkImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setImageUrl();
    }

    private void setImageUrl() {

        String url = "http://www.acrowavenet.com/wp/wp-content/themes/acrowavenet/images/common/header_logo.png";
        AppController app = (AppController)getApplication();

        image.setImageUrl(url, app.mImageLoader);
    }
}
