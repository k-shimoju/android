package com.all.app.android.all.ui.main.navi

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.all.app.android.all.R
import com.all.app.android.all.databinding.FragmentNaviBinding
import dagger.android.support.AndroidSupportInjection

class NaviFragment: Fragment() {

    val viewModel: NaviViewModel by lazy {
        ViewModelProviders.of(this).get(NaviViewModel::class.java)
    }

    lateinit var binding: FragmentNaviBinding

    var position: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentNaviBinding>(inflater, R.layout.fragment_navi,
                    container, false).also {
                binding = it
                binding.setLifecycleOwner(this)
                binding.navi = viewModel
            }.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        position = arguments?.getInt("POSITION")
    }
}