package com.example.mypopuplermovielist.util

class Staticdatautility {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY="0e412cc557213d3e83ceda3dc7ab7a13"
        private const val IMAGE_URL_PREFIX = "https://image.tmdb.org/t/p/"
        const val SMALL_IMAGE_URL_PREFIX: String = IMAGE_URL_PREFIX + "w300"
        const val BIG_IMAGE_URL_PREFIX: String = IMAGE_URL_PREFIX + "w500"
        //https://api.themoviedb.org/3/movie/popular?api_key=0e412cc557213d3e83ceda3dc7ab7a13&language=en-US&page=1

    }
}