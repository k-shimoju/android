package test.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shimoju_k on 2015/09/29.
 */
public class UserResponse {

    @SerializedName("user_name")
    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
