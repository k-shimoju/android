package com.all.app.android.all.ui.main.navi.result

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.all.app.android.all.R
import com.all.app.android.all.databinding.FragmentResultBinding
import dagger.android.support.AndroidSupportInjection

class ResultFragment: Fragment() {

    val viewModel: ResultViewModel by lazy {
        ViewModelProviders.of(this).get(ResultViewModel::class.java)
    }
    lateinit var binding: FragmentResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentResultBinding>(inflater, R.layout.fragment_result,
                    container, false).also {
                binding = it
                binding.setLifecycleOwner(this)
                binding.result = viewModel
            }.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }
}