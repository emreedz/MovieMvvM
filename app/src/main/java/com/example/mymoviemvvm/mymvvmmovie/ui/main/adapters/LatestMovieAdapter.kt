package com.example.mymoviemvvm.mymvvmmovie.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoviemvvm.databinding.LatestCardviewBinding
import com.example.mymoviemvvm.mymvvmmovie.models.movie.latest.LatestResult

class LatestMovieAdapter : ListAdapter<LatestResult, LatestMovieAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(val binding: LatestCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
                val latestCardViewBinding = LatestCardviewBinding.inflate(inflater, parent, false)
                return ViewHolder(latestCardViewBinding)
            }
        }

        fun bind(latestMovieResult: LatestResult?) {
            if (latestMovieResult != null) {
                binding.latest = latestMovieResult
                binding.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder.create(LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LatestResult>() {
            override fun areItemsTheSame(oldItem: LatestResult, newItem: LatestResult): Boolean {
                val latestId = oldItem.id == newItem.id
                return latestId
            }

            override fun areContentsTheSame(oldItem: LatestResult, newItem: LatestResult): Boolean {
                val latestTitle = oldItem.title == newItem.title
                return latestTitle
            }

        }
    }
}