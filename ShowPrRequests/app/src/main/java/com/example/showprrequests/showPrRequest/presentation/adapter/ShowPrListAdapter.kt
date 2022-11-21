package com.example.showprrequests.showPrRequest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.showprrequests.databinding.ShowPrListItemBinding
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse


class ShowPrListAdapter:ListAdapter<ShowPrListResponse, ShowPrListAdapterViewHolder>(
    ShowPrListAdapterDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowPrListAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ShowPrListItemBinding.inflate(layoutInflater, parent, false)
        return ShowPrListAdapterViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ShowPrListAdapterViewHolder, position: Int) {
        var showLoader = false
        if(position==itemCount-1){
            showLoader = true
        }
        holder.bindData(getItem(position),showLoader)
    }

}

