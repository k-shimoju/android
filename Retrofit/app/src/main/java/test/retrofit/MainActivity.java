package test.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import test.retrofit.model.UserResponse;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequest();
    }

    private void sendRequest() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://192.168.33.106:8080")
                .setConverter(new GsonConverter(new Gson()))
                .build();

        ApiInterface api = restAdapter.create(ApiInterface.class);
        api.getUser("test", 23, new Callback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse, Response response) {
                Toast.makeText(MainActivity.this, String.format("USER_NAME:%s AGE:%d", userResponse.getUserName(), userResponse.getAge()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
