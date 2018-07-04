package com.all.app.android.all.ui.main.repos_db

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.all.app.android.all.R
import com.all.app.android.all.databinding.FragmentRepoDbBinding
import com.all.app.android.all.ui.main.repos_db.adapter.RepoOwnerAdapter
import com.common.ext.observe
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_repo_db.*
import javax.inject.Inject

class ReposDbFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: ReposDbViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ReposDbViewModel::class.java)
    }

    lateinit var binding: FragmentRepoDbBinding

    val repoAdapter = RepoOwnerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentRepoDbBinding>(inflater, R.layout.fragment_repo_db,
                    container, false).also {
                binding = it
                binding.setLifecycleOwner(this)
                binding.repoDb = viewModel
            }.root

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
            layoutManager = android.support.v7.widget.LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}