package test.gson.model;

import java.util.List;

/**
 * Created by shimoju_k on 2015/09/24.
 */
public class ComplexityModel {

    private JsonModel model;
    private List<JsonModel> modelList;

    public JsonModel getModel() {
        return model;
    }

    public void setModel(JsonModel model) {
        this.model = model;
    }

    public List<JsonModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<JsonModel> modelList) {
        this.modelList = modelList;
    }
}
