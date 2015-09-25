package test.volley;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.volley.http.GetRequest;
import test.volley.http.PostRequest;

public class MainActivity extends Activity {

    @Bind(R.id.edit_word)
    EditText editWord;
    @Bind(R.id.txt_result)
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        editWord.setText("Tokyo,jp");
    }

    @OnClick(R.id.btn_get)
    protected void btnGet(View view) {

        Map<String, String> params = makeParameter();
        AppController app = (AppController)getApplication();
        GetRequest request = new GetRequest(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtResult.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, params);

        app.mRequestQueue.add(request);
    }

    @OnClick(R.id.btn_post)
    protected void btnPost(View view) {

        Map<String, String> params = makeParameter();
        AppController app = (AppController)getApplication();
        PostRequest request = new PostRequest(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtResult.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }, params);

        app.mRequestQueue.add(request);
    }

    private Map<String, String> makeParameter() {

        Map<String, String> params = new HashMap<>();

        params.put("q", editWord.getText().toString());

        return params;
    }
}
