package test.realm.model;

import io.realm.RealmObject;

/**
 * Created by shimoju_k on 2015/07/29.
 */
public class TestModel extends RealmObject {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
