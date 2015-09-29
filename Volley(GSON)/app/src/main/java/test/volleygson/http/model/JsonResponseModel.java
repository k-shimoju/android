package test.volleygson.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shimoju_k on 2015/09/28.
 */
public class JsonResponseModel {

    @SerializedName("user_name")
    private String userName;
    private String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
