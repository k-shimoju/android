package test.realm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import test.realm.model.TestModel;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RealmResults<TestModel> results = null;

        addTestData();
        addTestdataBestVer(2, "test2");
        addTestdataBestVer(3, "test3");
        results = getTestData();

        for (final TestModel model : results) {
            Log.d("REALM_TEST", String.format("ID: %s  NAME: %s", model.getId(), model.getName()));
        }

        updateTestData(results);
        deleteTestData(results);

        for (final TestModel model : getTestData()) {
            Log.d("REALM_TEST2", String.format("ID: %s  NAME: %s", model.getId(), model.getName()));
        }
    }

    private void addTestData() {

        Realm realm = Realm.getInstance(this, "test_realm");
        TestModel model = null;

        realm.beginTransaction();
        model = realm.createObject(TestModel.class);
        model.setId(1);
        model.setName("test");

        realm.commitTransaction();
    }

    private void addTestdataBestVer(int id, String name) {

        TestModel model = new TestModel();
        model.setId(id);
        model.setName(name);

        addTestDataBestVer(model);
    }

    private void addTestDataBestVer(TestModel model) {

        Realm realm = Realm.getInstance(this, "test_realm");

        realm.beginTransaction();
        realm.copyToRealm(model);
        realm.commitTransaction();
    }

    private RealmResults<TestModel> getTestData() {

        Realm realm = Realm.getInstance(this, "test_realm");
        RealmQuery<TestModel> query = realm.where(TestModel.class);

//        query.equalTo("name", "test");
//        query.or().equalTo("id", 2);
//        query.or().equalTo("id", 3);

        return query.findAll();
    }

    private void deleteTestData(RealmResults<TestModel> result) {

        Realm realm = Realm.getInstance(this, "test_realm");
        TestModel model = result.get(0);

        realm.beginTransaction();
        result.remove(1);

        model.removeFromRealm();

//        result.clear();
        realm.commitTransaction();
    }

    private void updateTestData(RealmResults<TestModel> result) {

        Realm realm = Realm.getInstance(this, "test_realm");
        TestModel model = result.get(2);

        realm.beginTransaction();
        model.setName("UPDATE");
        realm.commitTransaction();
    }
}
