package com.all.app.android.all.ui.main.repos_db.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.all.app.android.all.R
import com.all.app.android.all.data.local.entity.RepoOwner
import com.all.app.android.all.databinding.AdapterRepoDbBinding

class RepoOwnerAdapter(var items: List<RepoOwner>? = null): RecyclerView.Adapter<RepoOwnerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoOwnerAdapter.ViewHolder {

        val binding = DataBindingUtil.inflate<AdapterRepoDbBinding>(LayoutInflater.from(parent.context),
                R.layout.adapter_repo_db, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)
        holder.binding.repoDb = RepoOwnerViewModel(item?.id?: "id", item?.name?: "name",
                item?.avatar?: "")
    }

    inner class ViewHolder(var binding: AdapterRepoDbBinding): RecyclerView.ViewHolder(binding.root)
}