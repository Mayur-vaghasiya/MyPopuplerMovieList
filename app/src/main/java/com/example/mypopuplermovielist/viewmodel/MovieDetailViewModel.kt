package com.example.mypopuplermovielist.viewmodel

import android.app.Application
import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.network.ApiInterface
import com.example.myapplication.network.RetrofitInstance
import com.example.mypopuplermovielist.base.BaseViewModel
import com.example.mypopuplermovielist.model.GetMovieDetailResponse
import com.example.mypopuplermovielist.navigator.MovieListNavigator
import com.example.mypopuplermovielist.repository.MovieDetailRepository
import com.example.mypopuplermovielist.repository.MovieListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel(application: Application) :
    BaseViewModel<MovieListNavigator>(application) {

    var movieDetail: MutableLiveData<GetMovieDetailResponse> = MutableLiveData()
    var service: ApiInterface? = null

    fun getMovieDetails(id: Long) {
        service = RetrofitInstance.getRetrofitInstance()!!.create(ApiInterface::class.java)
        val call: Call<GetMovieDetailResponse>? = service?.getMovieDetail(637649)

        call?.enqueue(object : Callback<GetMovieDetailResponse> {
            override fun onResponse(
                @NonNull call: Call<GetMovieDetailResponse>,
                @NonNull response: Response<GetMovieDetailResponse>
            ) {
                if (response.code() == 200) {
                    movieDetail.value = response.body()
                    Log.e("Response", response.toString())
                }
            }

            override fun onFailure(call: Call<GetMovieDetailResponse>, t: Throwable) {
                movieDetail.value = null
            }
        })
    }
}