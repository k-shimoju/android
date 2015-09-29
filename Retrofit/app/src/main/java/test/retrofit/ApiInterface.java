package test.retrofit;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import test.retrofit.model.UserResponse;

/**
 * Created by shimoju_k on 2015/09/29.
 */
public interface ApiInterface {

    @GET("/user")
    void getUser(
        @Query("user_name") String userName,
        @Query("age") Integer age,
        retrofit.Callback<UserResponse> callback
    );
}
