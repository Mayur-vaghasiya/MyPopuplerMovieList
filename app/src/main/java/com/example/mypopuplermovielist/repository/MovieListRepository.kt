package com.example.mypopuplermovielist.repository

class MovieListRepository (){

   // var movieList: MutableLiveData<ArrayList<GetMoviesResponse.Result>> = MutableLiveData()
    //var service: ApiInterface? = null

/*    fun GetItemsImageList():MutableLiveData<ArrayList<GetMoviesResponse.Result>>{
        RetrofitInstance.getRetrofitInstance()!!.create(ApiInterface::class.java)
            .also { service = it }
        val call: Call<ArrayList<GetMoviesResponse.Result>>? = service?.getPopularMovies(API_KEY,"en-US",1)

        call?.enqueue(object : Callback<ArrayList<GetMoviesResponse.Result>> {
            override fun onResponse(@NonNull call: Call<ArrayList<GetMoviesResponse.Result>>, @NonNull response: Response<ArrayList<GetMoviesResponse.Result>>) {

                movieList.value=response.body()
                Log.e("Response",response.toString())
            }

            override fun onFailure(call: Call<ArrayList<GetMoviesResponse.Result>>, t: Throwable) {
                movieList.value=null
            }
        })

        return movieList
    }*/
}