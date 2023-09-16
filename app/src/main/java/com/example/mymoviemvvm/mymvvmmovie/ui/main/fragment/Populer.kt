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
import com.example.mymoviemvvm.mymvvmmovie.ui.main.adapters.MovieAdapter
import com.example.mymvvmmovie.common.BaseVMFragment
import com.example.mymvvmmovie.ui.main.populer.PopulerMoviesViewModel
import kotlinx.coroutines.launch

class Populer : BaseVMFragment<PopulerMoviesViewModel>() {

    private lateinit var adapter: MovieAdapter

    override fun getViewModel(): Class<PopulerMoviesViewModel> = PopulerMoviesViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_populer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MovieAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.popular_Rv)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)

        // CoroutineScope içinde işlemi yapın
        lifecycleScope.launch {
            val result = viewModel.getPopulerMovies()
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

                else -> {println("Hata")}
            }
        }
    }


}


