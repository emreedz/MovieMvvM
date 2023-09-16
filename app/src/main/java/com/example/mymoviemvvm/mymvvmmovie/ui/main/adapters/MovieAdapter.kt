package com.example.mymoviemvvm.mymvvmmovie.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoviemvvm.databinding.PopulerCardviewBinding
import com.example.mymoviemvvm.mymvvmmovie.models.movie.populer.PopulerResult

class MovieAdapter : ListAdapter<PopulerResult, MovieAdapter.ViewHolder>(DIFF_CALLBACK) {

   // private lateinit var movieClickListener: onMovieClickListener

    class ViewHolder(val binding: PopulerCardviewBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
                val populerCardviewBinding = PopulerCardviewBinding.inflate(inflater, parent, false)
                return ViewHolder(populerCardviewBinding)
            }
        }


        fun bind(movieResults: PopulerResult?) {
            if (movieResults != null) {
                binding.movie = movieResults
                binding.executePendingBindings()
            }
        }
    }

//    fun setOnMovieClickListener(movieClickListener: onMovieClickListener) {
//        this.movieClickListener = movieClickListener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder.create(LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PopulerResult>() {
            override fun areItemsTheSame(oldItem: PopulerResult, newItem: PopulerResult): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: PopulerResult,
                newItem: PopulerResult
            ): Boolean = oldItem.title == newItem.title
        }
    }

//    interface onMovieClickListener {
//        fun onMovieClick(populerMovieResults: PopulerResult?)
//    }

}