package com.example.mymoviemvvm.mymvvmmovie.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoviemvvm.databinding.BestCardviewBinding
import com.example.mymoviemvvm.mymvvmmovie.models.movie.best.BestResults

class BestMovieAdapter : ListAdapter<BestResults, BestMovieAdapter.ViewHolder>(DIFF_CALLBACk) {
    class ViewHolder(val binding: BestCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
                val bestCardviewBinding = BestCardviewBinding.inflate(inflater, parent, false)
                return ViewHolder(bestCardviewBinding)
            }
        }

        fun bind(bestMovieResult: BestResults?) {
            if (bestMovieResult != null) {
                binding.best = bestMovieResult
                binding.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder.create(LayoutInflater.from(parent.context), parent)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        val DIFF_CALLBACk = object : DiffUtil.ItemCallback<BestResults>() {
            override fun areItemsTheSame(oldItem: BestResults, newItem: BestResults): Boolean {
                val bestId = oldItem.id == newItem.id
                return bestId
            }

            override fun areContentsTheSame(oldItem: BestResults, newItem: BestResults): Boolean {
                val bestTitle = oldItem.title == newItem.title
                return bestTitle
            }

        }
    }
}