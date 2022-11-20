package com.example.showprrequests.showPrRequest.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.showprrequests.R
import com.example.showprrequests.ShowPrApplication
import com.example.showprrequests.showPrRequest.di.showpr.ShowPrComponent
import javax.inject.Inject

class ShowPrListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ShowPrVmFactory

    lateinit var viewModel: ShowPrListViewModel
    lateinit var showPrComponent:ShowPrComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        //Create Dependencies
        showPrComponent = ShowPrApplication.instance.appComponent.showPrComponent().create()
        showPrComponent.inject(this)

        super.onCreate(savedInstanceState)
        //create instance of view model

        viewModel = ViewModelProvider(this,viewModelFactory)[ShowPrListViewModel::class.java]
        viewModel.prListData.observe(this, Observer {
            Log.d("Received All Data::","Here::"+it.size)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_pr_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ShowPrListFragment()
    }
}