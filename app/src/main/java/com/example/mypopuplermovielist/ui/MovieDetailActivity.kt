package com.example.mypopuplermovielist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.adapters.ViewGroupBindingAdapter.setListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mypopuplermovielist.BR
import com.example.mypopuplermovielist.R
import com.example.mypopuplermovielist.base.BaseActivity
import com.example.mypopuplermovielist.databinding.ActivityMainBinding
import com.example.mypopuplermovielist.databinding.ActivityMovieDetailBinding
import com.example.mypopuplermovielist.model.GetMovieDetailResponse
import com.example.mypopuplermovielist.model.MoviesResponse
import com.example.mypopuplermovielist.navigator.MovieListNavigator
import com.example.mypopuplermovielist.util.Staticdatautility
import com.example.mypopuplermovielist.viewmodel.MovieDetailViewModel
import com.example.mypopuplermovielist.viewmodel.MovieListViewModel

class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding, MovieDetailViewModel>(),
    View.OnClickListener,
    MovieListNavigator {
    private lateinit var binding: ActivityMovieDetailBinding
    lateinit var movieDetailVM: MovieDetailViewModel
    var movieId: Long = 637649
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.extras != null) {
            movieId = intent.extras!!.getLong("movieId")

        }
        setDefaultValues()
        setHeader()
        setListener()
        setObservers()
    }

    private fun setDefaultValues() {
        binding = getViewDataBinding()
        binding?.let {
            it.lifecycleOwner = this@MovieDetailActivity
            it.movieDetailVM = movieDetailVM
        }
        movieDetailVM.attachContext(this)
        movieDetailVM.setNavigator(this)
        this
    }

    override fun setHeader() {
        binding.headerBar.tvTitle.text = getString(R.string.moviedetail)
    }

    private fun setListener() {
        binding.headerBar.ivBack.setOnClickListener(this)
    }

    override val bindingVariable: Int
        get() = BR.movieDetailVM
    override val layoutId: Int
        get() = R.layout.activity_movie_detail;
    override val viewModel: MovieDetailViewModel
        get() {
            movieDetailVM = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
            return movieDetailVM
        }

    override fun setObservers() {

        movieDetailVM.getMovieDetails(497698)
        viewModel.movieDetail.observe(this, Observer<GetMovieDetailResponse> {
            binding.movieTitle.text = it.getTitle()
            binding.movieTagline.text=it.getTagline()
            binding.movieUrl.text=it.getHomepage()
            binding.movieBudget.text = it.getBudget().toString()
            binding.movieRevenue.text = it.getRevenue().toString()
            binding.movieReleaseDate.text=it.getReleaseDate()
            binding.movieRating.text= it.getVoteAverage().toString()
            binding.movieRuntime.text= it.getRuntime().toString()+" Min"
            binding.movieReleaseDate.text= it.getReleaseDate()
            binding.movieOverview.text=it.getOverview()
            Glide.with(this).load(Staticdatautility.SMALL_IMAGE_URL_PREFIX + it.getPosterPath())
                .into(binding.ivMoviePoster)

        })
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
}