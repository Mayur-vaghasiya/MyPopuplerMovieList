package com.example.mypopuplermovielist.repository

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mypopuplermovielist.network.ApiInterface
import com.example.myapplication.network.RetrofitInstance
import com.example.mypopuplermovielist.model.GetMovieDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailRepository {

    var movieList: MutableLiveData<GetMovieDetailResponse> = MutableLiveData()
    var service: ApiInterface? = null

    fun getMovieDetails(id:Long): LiveData<GetMovieDetailResponse> {
        service = RetrofitInstance.getRetrofitInstance()!!.create(ApiInterface::class.java)
        val call: Call<GetMovieDetailResponse>? = service?.getMovieDetail(497698)

        call?.enqueue(object : Callback<GetMovieDetailResponse> {
            override fun onResponse(
                @NonNull call: Call<GetMovieDetailResponse>,
                @NonNull response: Response<GetMovieDetailResponse>
            ) {

                movieList.value = response.body()
                Log.e("Response", movieList.toString())
            }

            override fun onFailure(call: Call<GetMovieDetailResponse>, t: Throwable) {
                movieList.value = null
            }
        })

        return movieList
    }
}