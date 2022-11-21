package com.example.showprrequests.showPrRequest.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.showprrequests.databinding.ShowPrListItemBinding
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse

class ShowPrListAdapter:ListAdapter<ShowPrListResponse,ShowPrListAdapterViewHolder>(ShowPrListAdapterDiffUtil()) {

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
          binding.tvClosedAt.text = item.closed_at
          binding.tvTitle.text = item.title
          binding.tvUserName.text = item.user?.login
          binding.tvCreatedAt.text = item.created_at
      }

}

class ShowPrListAdapterDiffUtil:DiffUtil.ItemCallback<ShowPrListResponse>(){
    override fun areItemsTheSame(
        oldItem: ShowPrListResponse,
        newItem: ShowPrListResponse
    ): Boolean {
        return  oldItem.title == oldItem.title
    }

    override fun areContentsTheSame(
        oldItem: ShowPrListResponse,
        newItem: ShowPrListResponse
    ): Boolean {
        return oldItem==newItem
    }

}