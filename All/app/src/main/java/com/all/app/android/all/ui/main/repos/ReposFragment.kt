package com.all.app.android.all.ui.main.repos

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.all.app.android.all.R
import com.all.app.android.all.databinding.FragmentReposBinding
import com.all.app.android.all.ui.main.repos.adapter.ReposAdapter
import com.common.ext.observe
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_repos.*
import javax.inject.Inject

class ReposFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: ReposViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ReposViewModel::class.java)
    }

    lateinit var binding: FragmentReposBinding

    val repoAdapter = ReposAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentReposBinding>(inflater, R.layout.fragment_repos,
                    container, false).also {
                binding = it
                binding.setLifecycleOwner(this)
                binding.vm = viewModel
            }.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        viewModel.repoList.observe(this) {
            repoAdapter.items = it
            repoAdapter.notifyDataSetChanged()
        }
    }

    fun setRecyclerView() {

        with (recyclerView) {
            adapter = repoAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}