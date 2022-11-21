package com.example.showprrequests.showPrRequest.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.showprrequests.databinding.ShowPrListItemBinding
import com.example.showprrequests.showPrRequest.common.AppUtil
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import com.example.showprrequests.showPrRequest.presentation.adapter.ShowPrListAdapterDiffUtil


class ShowPrListAdapter:ListAdapter<ShowPrListResponse,ShowPrListAdapterViewHolder>(
    ShowPrListAdapterDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowPrListAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ShowPrListItemBinding.inflate(layoutInflater,parent,false)
        return ShowPrListAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowPrListAdapterViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

}

class ShowPrListAdapterViewHolder(private val binding: ShowPrListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bindData(item:ShowPrListResponse){
        setData(item)
        AppUtil.loadImage(binding.imgUserLogo,item.user?.avatar_url!!)
    }

    private fun setData(item:ShowPrListResponse){

        binding.tvClosedAt.text = item.closed_at
        binding.tvTitle.text = item.title
        binding.tvUserName.text = item.user?.login
        binding.tvCreatedAt.text = item.created_at
    }

}

