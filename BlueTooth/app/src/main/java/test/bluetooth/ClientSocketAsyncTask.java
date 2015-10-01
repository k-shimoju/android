package test.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

/**
 * Created by k-shimoju on 2015/10/01.
 */
public class ClientSocketAsyncTask extends AsyncTask<BluetoothAdapter, Void, BluetoothSocket> {


    @Override
    protected BluetoothSocket doInBackground(BluetoothAdapter... params) {
        return null;
    }
}
