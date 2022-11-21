package com.example.showprrequests.showPrRequest.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.showprrequests.databinding.ShowPrListItemBinding
import com.example.showprrequests.showPrRequest.common.AppUtil
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse

class ShowPrListAdapterViewHolder(private val binding: ShowPrListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bindData(item: ShowPrListResponse,showLoader:Boolean){
        setData(item,showLoader)
        AppUtil.loadImage(binding.imgUserLogo, item.user?.avatar_url!!)
    }

    private fun setData(item: ShowPrListResponse,showLoader: Boolean){

        binding.loader.visibility = if(showLoader) View.VISIBLE else View.GONE
        binding.tvClosedAt.text = item.closed_at
        binding.tvTitle.text = item.title
        binding.tvUserName.text = item.user?.login
        binding.tvCreatedAt.text = item.created_at
    }

}