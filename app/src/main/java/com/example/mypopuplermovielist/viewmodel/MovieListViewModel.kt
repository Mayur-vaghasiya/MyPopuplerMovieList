package com.example.mypopuplermovielist.viewmodel

import android.app.Application
import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.network.ApiInterface
import com.example.myapplication.network.RetrofitInstance
import com.example.mypopuplermovielist.base.BaseViewModel
import com.example.mypopuplermovielist.model.GetMovieDetailResponse
import com.example.mypopuplermovielist.model.GetMoviesResponse
import com.example.mypopuplermovielist.navigator.MovieListNavigator
import com.example.mypopuplermovielist.util.Staticdatautility.Companion.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel(application: Application) :
    BaseViewModel<MovieListNavigator>(application) {
    var service: ApiInterface? = null
    /*private var mutableLiveGetMovieList: MutableLiveData<ArrayList<GetMoviesResponse.Movie>>? = null
    private var movieListRepository: MovieListRepository = MovieListRepository()

    init {
        mutableLiveGetMovieList=movieListRepository.GetItemsImageList()
    }

    fun getMovieList(): MutableLiveData<ArrayList<GetMoviesResponse.Movie>>? {
        return mutableLiveGetMovieList
    }*/
    var recyclerListData: MutableLiveData<GetMoviesResponse.Result> = MutableLiveData()

    fun getRecyclerListDataObserver(): MutableLiveData<GetMoviesResponse.Result> {
        return recyclerListData
    }

    fun getMovieImageList(){
        service = RetrofitInstance.getRetrofitInstance()!!.create(ApiInterface::class.java)
        val call: Call<GetMoviesResponse>? = service?.getPopularMovies(API_KEY)

        call?.enqueue(object : Callback<GetMoviesResponse> {
            override fun onResponse(
                @NonNull call: Call<GetMoviesResponse>,
                @NonNull response: Response<GetMoviesResponse>
            ) {
                if (response.code() == 200) {
                    recyclerListData.value = response.body()?.Result()
                    Log.e("Response", response.toString())
                }
            }

            override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                recyclerListData.value = null
            }
        })

    }
}