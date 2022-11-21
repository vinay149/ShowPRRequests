package com.example.showprrequests.showPrRequest.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse

class ShowPrListAdapterDiffUtil: DiffUtil.ItemCallback<ShowPrListResponse>(){

    override fun areItemsTheSame( oldItem: ShowPrListResponse,
                                  newItem: ShowPrListResponse
    ): Boolean {
        return  oldItem.id == oldItem.id
    }

    override fun areContentsTheSame( oldItem: ShowPrListResponse,
                                     newItem: ShowPrListResponse): Boolean {
        return oldItem==newItem
    }

}