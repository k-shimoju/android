package test.volley.http;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by shimoju_k on 2015/09/25.
 */
public class PostRequest extends StringRequest {

    private Map<String, String> mParams;
    private static final String URL = "http://ave.bolyartech.com/params.php";

    public PostRequest(Response.Listener<String> listener, Response.ErrorListener errorListener, Map<String, String> params) {

        super(Method.POST, URL, listener, errorListener);
        mParams = params;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {

        return mParams;
    }
}
