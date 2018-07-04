package com.all.app.android.all.ui.main.repos.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.all.app.android.all.R
import com.all.app.android.all.data.network.api.model.Repo
import com.all.app.android.all.databinding.AdapterReposBinding

class ReposAdapter(var items: List<Repo>? = null): RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<AdapterReposBinding>(LayoutInflater.from(parent.context),
                R.layout.adapter_repos, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)
        holder.binding.repo = ReposAdapterViewModel(item?.id?: "id", item?.name?: "name",
                item?.owner?.avatar?: "")
    }

    inner class ViewHolder(val binding: AdapterReposBinding): RecyclerView.ViewHolder(binding.root)
}