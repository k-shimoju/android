package test.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothDevice mDevice;
    private BroadcastReceiver mDeviceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(BluetoothDevice.ACTION_FOUND.equals(intent.getAction())){
                mDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Toast.makeText(MainActivity.this, mDevice.getName(), Toast.LENGTH_SHORT).show();
                mBluetoothAdapter.cancelDiscovery();
                Toast.makeText(MainActivity.this, "準備完了", Toast.LENGTH_SHORT).show();
            }
        }
    };
    private final int INTENT_REQUEST_CODE = 1234567;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBuleToothSetting();
    }

    private void initBuleToothSetting() {

        Intent intent;

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (null != mBluetoothAdapter && !mBluetoothAdapter.isEnabled()) {
            intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, INTENT_REQUEST_CODE);
        } else if (null != mBluetoothAdapter) {
            Toast.makeText(this, "何もしなくても動きます", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "この端末では動きません", Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == INTENT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "準備完了", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "有効になりませんでした", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R.id.paire_device)
    protected void getPairedDevices(View view) {

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        for (BluetoothDevice device: pairedDevices) {
            mDevice = device;
        }
        Toast.makeText(this, "準備完了", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.search_device)
    protected void searchDevice(View view) {

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);

        registerReceiver(mDeviceReceiver, filter);

        if (mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        }
        mBluetoothAdapter.startDiscovery();
    }

    @OnClick(R.id.client_connect)
    protected void btnClient(View view) {

        clientConnect(mDevice);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        try {
            unregisterReceiver(mDeviceReceiver);
        } catch (Exception e) {
            Log.e("error", e.getMessage());
        }
    }

    private void clientConnect(BluetoothDevice device) {

        BluetoothSocket socket = null;

        try {
            socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            socket.connect();
        } catch (Exception e){
            Log.e("error", e.getMessage());
        }

        startDataTransfer(socket, false);
    }

    @OnClick(R.id.server_connect)
    protected void serverConnect(View view) {

        ServerSocketAsyncTask task = new ServerSocketAsyncTask(this);

        task.execute(mBluetoothAdapter);
    }

    public void startDataTransfer(BluetoothSocket socket, boolean serverFlg) {

        InputStream in = null;
        OutputStream out = null;
        byte[] buffer = new byte[1024];
        int buf = 0;

        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
        } catch(Exception e) {
            Log.e("error", e.getMessage());
        }

        try {
            if (!serverFlg) {
                out.write("TEST".getBytes());
            } else {
                while (true) {
                    buf = in.read(buffer);
                    if (0 != buf) {
                        Toast.makeText(MainActivity.this, "DATA: " + new String(buffer), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } catch(Exception e) {
            Log.e("error", e.getMessage());
        } finally {
            try{
                out.close();
                in.close();
                Toast.makeText(MainActivity.this, "CLOSEしました", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {}
        }
    }
}
