package com.example.showprrequests.showPrRequest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.showprrequests.ShowPrApplication
import com.example.showprrequests.databinding.FragmentShowPrListBinding
import com.example.showprrequests.showPrRequest.common.AppUtil
import com.example.showprrequests.showPrRequest.di.showpr.ShowPrComponent
import com.example.showprrequests.showPrRequest.presentation.adapter.ShowPrListAdapter
import com.example.showprrequests.showPrRequest.presentation.adapter.ShowPrListState
import com.example.showprrequests.showPrRequest.presentation.adapter.ShowPrListViewModel
import javax.inject.Inject


class ShowPrListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ShowPrVmFactory
    private lateinit var viewModel: ShowPrListViewModel

    lateinit var showPrComponent:ShowPrComponent
    lateinit var binding:FragmentShowPrListBinding
    lateinit var recyclerView: RecyclerView

    private val adapter: ShowPrListAdapter by lazy {
        ShowPrListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initInjection()
        super.onCreate(savedInstanceState)

        //create instance of view model
        viewModel = ViewModelProvider(this,viewModelFactory)[ShowPrListViewModel::class.java]
        viewModel.loadData()
        observerData()
    }

    private fun initInjection(){
        showPrComponent = ShowPrApplication.instance.appComponent.showPrComponent().create()
        showPrComponent.inject(this)
    }

    private fun observerData(){
        observerPrData()
        observerState()
    }

    private fun observerPrData(){
        viewModel.prListData.observe(this, Observer {
            if(it.isNotEmpty()) {
                adapter.submitList(it)
                isLoading  = false
                showAndHideEmptyState(hide = true)
            }else{
                showAndHideEmptyState(hide = false)
            }
        })
    }

    private fun observerState(){
        viewModel.dataFetchingState.observe(this) {
            when (it) {
                ShowPrListState.LOADING -> {
                    binding.loader.visibility = View.VISIBLE
                }
                ShowPrListState.FAILED -> {
                    binding.loader.visibility = View.GONE
                    Toast.makeText(
                        context,
                        "SomeThing went wrong please try after some time",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    binding.loader.visibility = View.GONE
                }
            }
        }
    }

    private fun showAndHideEmptyState(hide:Boolean){
            binding.tvEmptyState.visibility = if(hide)View.GONE else View.VISIBLE
            binding.rvShowPrList.visibility = if(hide)View.VISIBLE else View.GONE
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
        initRecyclerView()
        initScrollListener()
    }

    private fun initRecyclerView(){
        recyclerView = binding.rvShowPrList
        recyclerView.adapter = adapter
    }
    var isLoading = false
    private fun initScrollListener() {

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (adapter.itemCount.minus(
                            1
                        ) )
                    ) {
                        loadMore()
                        isLoading = true
                    }
                }
            }
        })
    }

    private fun loadMore(){
        if(AppUtil.isNetworkAvailable()){
           viewModel.loadData()
        }else{
            Toast.makeText(
                context,
                "Please check internet connection",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}
