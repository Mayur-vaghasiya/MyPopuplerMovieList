package com.example.mypopuplermovielist.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypopuplermovielist.R
import com.example.mypopuplermovielist.databinding.RowMovieposterBinding
import com.example.mypopuplermovielist.model.GetMoviesResponse
import com.example.mypopuplermovielist.ui.MovieDetailActivity
import com.example.mypopuplermovielist.util.Staticdatautility.Companion.BIG_IMAGE_URL_PREFIX

class MovieImageAdapter(
    private val context: Context,
    movieList: ArrayList<GetMoviesResponse.Result>,

    ) :
    RecyclerView.Adapter<MovieImageAdapter.MyViewHolder>() {
    var movieList: ArrayList<GetMoviesResponse.Result> = movieList
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val bind: RowMovieposterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.row_movieposter,
            parent,
            false
        )
        return MyViewHolder(bind)
    }

    fun updateBuyerList(moviesList: ArrayList<GetMoviesResponse.Result>) {
        this.movieList = moviesList
        notifyDataSetChanged()
    }
    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(context).load(BIG_IMAGE_URL_PREFIX + movieList.get(position).posterPath)
            .into(holder.bind.imageviewMoviePoster)

        holder.bind.imageviewMoviePoster.setOnClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra("movieId",movieList[position].id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MyViewHolder(
        bind: RowMovieposterBinding
    ) : RecyclerView.ViewHolder(bind.root) {
        val bind: RowMovieposterBinding = bind


    }
}


