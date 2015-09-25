package test.volley.http;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by shimoju_k on 2015/09/25.
 */
public class GetRequest extends StringRequest {

    private Map<String, String> mParams;
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather";

    public GetRequest(Response.Listener<String> listener, Response.ErrorListener errorListener, Map<String, String> mParams) {
        super(Method.GET, URL, listener, errorListener);
        this.mParams = mParams;
    }

    @Override
    public String getUrl() {
        return super.getUrl() + makeGetParameter();
    }

    private String makeGetParameter() {

        String param = "?";
        boolean isFirst = true;

        for (Map.Entry<String, String> entry : mParams.entrySet()) {
            if (isFirst) {
                param += entry.getKey() + "=" + entry.getValue();
            } else {
                param += "&" + entry.getKey() + "=" + entry.getValue();
            }
        }

        return param;
    }
}
