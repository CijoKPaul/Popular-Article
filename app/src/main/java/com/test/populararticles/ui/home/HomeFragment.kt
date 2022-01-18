package com.test.populararticles.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutineretrofitdemo.viewmodel.ListViewModel
import com.test.populararticles.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    val viewModel by viewModels<ListViewModel>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val  view : View = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel.fetchArticles()

        activity?.let {
            viewModel.artilcesLiveData.observe(viewLifecycleOwner, Observer {
                customAdapter = CustomAdapter(it.results)
                val layoutManager = LinearLayoutManager(activity)
                rvView.layoutManager = layoutManager
                rvView.adapter = customAdapter
                customAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            })
        }

        activity?.let {
            viewModel.articleLoadError.observe(viewLifecycleOwner, Observer {
                println(it)
                progressBar.visibility = View.GONE
            })
        }

        return view
    }




}