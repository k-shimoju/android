package test.gson;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.gson.model.ComplexityModel;
import test.gson.model.JsonModel;

public class MainActivity extends Activity {

    @Bind(R.id.edit_json)
    EditText txtJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private JsonModel makeJsonModel() {

        JsonModel model = new JsonModel();

        model.setUserName("TAROH YAMADA");
        model.setAge(93);

        return model;
    }

    @OnClick(R.id.btn_to_json)
    protected void clickToJson(View view) {

        Gson gson = new Gson();
        String json = gson.toJson(makeJsonModel());

        txtJson.setText(json);
    }

    @OnClick(R.id.btn_format_json)
    protected void clickFormatJson(View view) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(makeJsonModel());

        txtJson.setText(json);
    }

    @OnClick(R.id.btn_from_json)
    protected void clickFromJson(View view) {

        String json = txtJson.getText().toString();
        Gson gson = new Gson();
        JsonModel model = null;

        if (json == null || "".equals(json.trim())) {
            Toast.makeText(this, "JSONを入力してください", Toast.LENGTH_SHORT).show();
            return;
        }

        model = gson.fromJson(json, JsonModel.class);
        Toast.makeText(this, "user_name: " + model.getUserName() + " age: " + model.getAge(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.complexity_to_json)
    protected void clickComplexityToJson(View view) {

        ComplexityModel model = new ComplexityModel();
        JsonModel jsonModel = makeJsonModel();
        List<JsonModel> modelList = makeModelList();
        String json = null;
        Gson gson = new Gson();

        model.setModel(jsonModel);
        model.setModelList(modelList);
        json = gson.toJson(model);

        txtJson.setText(json);
    }

    @OnClick(R.id.complexity_from_json)
    protected void clickComplexityFromJson(View view) {

        Gson gson = new Gson();
        String json = txtJson.getText().toString();
        ComplexityModel model = null;

        if (json == null || "".equals(json.trim())) {
            Toast.makeText(this, "JSONを入力してください", Toast.LENGTH_SHORT).show();
            return;
        }

        model = gson.fromJson(json, ComplexityModel.class);
    }

    private List<JsonModel> makeModelList() {

        List<JsonModel> modelList = new ArrayList<>();

        for (int i=0; i<10; i++) {
            modelList.add(makeJsonModel());
        }

        return modelList;
    }
}
