package com.example.mypopuplermovielist.network

import com.example.mypopuplermovielist.model.GetMovieDetailResponse
import com.example.mypopuplermovielist.model.GetMoviesResponse
import com.example.mypopuplermovielist.util.Staticdatautility.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

/*    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String ,
        @Query("language") language: String ,
        @Query("page") page: Int
    ): Call<GetMoviesResponse.Result>*/

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
    ): Call<GetMoviesResponse.Result>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId:Long?,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en-US"
    ): Call<GetMovieDetailResponse>

}