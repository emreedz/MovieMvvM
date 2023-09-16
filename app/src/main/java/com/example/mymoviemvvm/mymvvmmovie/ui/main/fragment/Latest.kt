package com.example.mymoviemvvm.mymvvmmovie.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoviemvvm.R
import com.example.mymoviemvvm.mymvvmmovie.models.MyResult
import com.example.mymoviemvvm.mymvvmmovie.ui.main.adapters.LatestMovieAdapter
import com.example.mymoviemvvm.mymvvmmovie.ui.main.latest.LatestMoviesViewModel
import com.example.mymvvmmovie.common.BaseVMFragment
import kotlinx.coroutines.launch

class Latest : BaseVMFragment<LatestMoviesViewModel>() {

    private lateinit var adapter: LatestMovieAdapter
    override fun getViewModel(): Class<LatestMoviesViewModel> = LatestMoviesViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = LatestMovieAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.latest_Rv)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)


        lifecycleScope.launch {
            val result= viewModel.getLatestMovies()
            when (result) {
                is MyResult.Success -> {
                    val data = result.data
                    adapter.submitList(data)
                    recyclerView.adapter = adapter
                    
                }
                is MyResult.Error -> {
                    // Hata durumu
                    val errorMessage = result.exception.message ?: "Error getting popular movies"
                    println(errorMessage)
                    // Hata mesajını işleyin veya görüntüleyin
                }
                else -> {}
            }

        }



    }

}