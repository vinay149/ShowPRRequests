package com.example.showprrequests.showPrRequest.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.showprrequests.R
import com.example.showprrequests.ShowPrApplication
import com.example.showprrequests.databinding.FragmentShowPrListBinding
import com.example.showprrequests.showPrRequest.di.showpr.ShowPrComponent
import com.google.gson.Gson
import javax.inject.Inject

class ShowPrListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ShowPrVmFactory

    private lateinit var viewModel: ShowPrListViewModel
    lateinit var showPrComponent:ShowPrComponent
    lateinit var binding:FragmentShowPrListBinding
    lateinit var recyclerView: RecyclerView

    private val adapter:ShowPrListAdapter by lazy {
        ShowPrListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        //Create Dependencies
        showPrComponent = ShowPrApplication.instance.appComponent.showPrComponent().create()
        showPrComponent.inject(this)

        super.onCreate(savedInstanceState)

        //create instance of view model

        viewModel = ViewModelProvider(this,viewModelFactory)[ShowPrListViewModel::class.java]
        viewModel.loadData()
        viewModel.prListData.observe(this, Observer {
            Log.d("DataFetched","here"+Gson().toJson(it))
            adapter.submitList(it)
        })


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentShowPrListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rvShowPrList

        recyclerView.adapter = adapter


    }

    companion object {
        @JvmStatic
        fun newInstance() = ShowPrListFragment()
    }
}
