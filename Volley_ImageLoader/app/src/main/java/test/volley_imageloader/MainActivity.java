package test.volley_imageloader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import test.volley_imageloader.model.ImageListModel;

public class MainActivity extends Activity {

    @Bind(R.id.list_sample)
    ListView imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ImageAdapter adapter = new ImageAdapter(this, R.id.txt_name, makeImageListModel());
        imageList.setAdapter(adapter);
    }

    private List<ImageListModel> makeImageListModel() {

        List<ImageListModel> list = new ArrayList<>();
        ImageListModel model = null;

        for (int i=0; i<10; i++) {
            model = new ImageListModel();
            model.setImageUrl("http://www.acrowavenet.com/wp/wp-content/themes/acrowavenet/images/common/header_logo.png");
            model.setName("株式会社アクロウェーブネット");
            list.add(model);
        }

        return list;
    }
}
