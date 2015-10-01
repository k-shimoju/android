package test.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;
import android.util.Log;

import java.util.UUID;

/**
 * Created by k-shimoju on 2015/10/01.
 */
public class ServerSocketAsyncTask extends AsyncTask<BluetoothAdapter, Void, BluetoothSocket> {

    private BluetoothAdapter mAdapter;
    private BluetoothServerSocket mServerSocket;
    private final String SOCKET_NAME = "SAMPLE_NAME";
    private final UUID SOCKET_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private MainActivity mContext;

    public ServerSocketAsyncTask(MainActivity context) {
        mContext = context;
    }

    @Override
    protected BluetoothSocket doInBackground(BluetoothAdapter... params) {

        BluetoothSocket socket = null;
        mAdapter = params[0];

        try {
            mServerSocket = mAdapter.listenUsingRfcommWithServiceRecord(SOCKET_NAME, SOCKET_UUID);
        } catch (Exception e) {
            Log.e("error", e.getMessage());
        }

        while (null == socket) {
            try {
                socket = mServerSocket.accept();
            } catch (Exception e) {
                Log.e("error", e.getMessage());
            }
        }

        try {
            mServerSocket.close();
        } catch(Exception e) {
            Log.e("error", e.getMessage());
        }

        return socket;
    }

    @Override
    protected void onPostExecute(BluetoothSocket socket) {

        super.onPostExecute(socket);
        mContext.startDataTransfer(socket, true);
    }
}
