package com.example.mypopuplermovielist.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypopuplermovielist.network.ApiInterface
import com.example.mypopuplermovielist.BR
import com.example.mypopuplermovielist.R
import com.example.mypopuplermovielist.adapter.MovieImageAdapter
import com.example.mypopuplermovielist.base.BaseActivity
import com.example.mypopuplermovielist.databinding.ActivityMainBinding
import com.example.mypopuplermovielist.model.GetMoviesResponse
import com.example.mypopuplermovielist.model.GetMoviesResponse.*
import com.example.mypopuplermovielist.navigator.MovieListNavigator
import com.example.mypopuplermovielist.viewmodel.MovieListViewModel


class MainActivity : BaseActivity<ActivityMainBinding, MovieListViewModel>(), MovieListNavigator,
    View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var movieListVM: MovieListViewModel
    private lateinit var movieImageAdapter: MovieImageAdapter
    private var movieList: ArrayList<GetMoviesResponse.Result> = ArrayList()
    var service: ApiInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDefaultValues()
        setHeader()
        setListener()
        setUpRecyclerView()
        setObservers()
    }

    override fun setHeader() {
        binding.headerBar.tvTitle.text = getString(R.string.movielist)
    }

    private fun setListener() {
        binding.headerBar.ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (v.id) {
                R.id.ivBack -> {
                    onBackPressed()
                }
            }
        }
    }

    private fun setDefaultValues() {
        binding = getViewDataBinding()
        binding?.let {
            it.lifecycleOwner = this@MainActivity
            it.movieListVM = movieListVM
        }
        movieListVM.attachContext(this)
        movieListVM.setNavigator(this)
        this
    }

    private fun setUpRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            false
        )

        movieImageAdapter =
            MovieImageAdapter(this, movieList)
        binding.recyclerViewMovieList.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = movieImageAdapter
        }
    }

    override val bindingVariable: Int
        get() = BR.movieListVM
    override val layoutId: Int
        get() = R.layout.activity_main;
    override val viewModel: MovieListViewModel
        get() {
            movieListVM = ViewModelProvider(this).get(MovieListViewModel::class.java)
            return movieListVM
        }

    override fun setObservers() {
        movieListVM.getMovieImageList();
        viewModel.getRecyclerListDataObserver().observe(this,
            Observer { it ->
                it?.let {
                    movieList.addAll(listOf(it))
                    movieImageAdapter.notifyDataSetChanged()
                }
            })
    }
}

