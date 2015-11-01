package com.k_shimoju.zxing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.integration.android.IntentIntegrator;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by naomi on 2015/11/01.
 */
public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn_barcode)
    protected void btnReadIsbn() {

        IntentIntegrator integrator = IntentIntegrator.forSupportFragment(this);

        integrator.initiateScan();
    }
}
