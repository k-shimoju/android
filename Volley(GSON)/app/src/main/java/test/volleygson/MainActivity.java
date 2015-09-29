package test.volleygson;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.volleygson.http.GsonRequest;
import test.volleygson.http.model.JsonResponseModel;

public class MainActivity extends Activity {

    @Bind(R.id.edit_word)
    EditText keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_request)
    protected void onClick(View view) {

        AppController application = (AppController)getApplication();
        GsonRequest<JsonResponseModel> request = new GsonRequest("http://localhost:8080/", JsonResponseModel.class, null, makeParameter(), new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                JsonResponseModel model = (JsonResponseModel)response;
                // あとはよしなに
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        application.mRequestQueue.add(request);
    }

    private Map<String, String> makeParameter() {

        Map<String, String> param = new HashMap<>();

        param.put("key", keyword.getText().toString());

        return param;
    }
}
