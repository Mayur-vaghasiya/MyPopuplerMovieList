package com.example.mypopuplermovielist.viewmodel

import android.app.Application
import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.example.mypopuplermovielist.network.ApiInterface
import com.example.myapplication.network.RetrofitInstance
import com.example.mypopuplermovielist.base.BaseViewModel
import com.example.mypopuplermovielist.model.GetMoviesResponse
import com.example.mypopuplermovielist.navigator.MovieListNavigator
import com.example.mypopuplermovielist.util.Staticdatautility.Companion.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel(application: Application) :
    BaseViewModel<MovieListNavigator>(application) {
    var service: ApiInterface? = null
    var recyclerListData: MutableLiveData<GetMoviesResponse.Result> = MutableLiveData()

    fun getRecyclerListDataObserver(): MutableLiveData<GetMoviesResponse.Result> {
        return recyclerListData
    }

    fun getMovieImageList() {
        service = RetrofitInstance.getRetrofitInstance()!!.create(ApiInterface::class.java)
        val call: Call<GetMoviesResponse.Result>? = service?.getPopularMovies(API_KEY)

        call?.enqueue(object : Callback<GetMoviesResponse.Result> {
            override fun onResponse(
                @NonNull call: Call<GetMoviesResponse.Result>,
                @NonNull response: Response<GetMoviesResponse.Result>
            ) {

                recyclerListData.value = response.body()
                val responseBody = response.body()
                Log.e("Repository", "Movies: ${response}")
                if (responseBody != null) {
                    Log.e("Repository", "Movies: ${responseBody}")
                } else {
                    Log.e("Repository", "Failed to get response")
                }

            }

            override fun onFailure(call: Call<GetMoviesResponse.Result>, t: Throwable) {
                recyclerListData.value = null
            }
        })

    }
}