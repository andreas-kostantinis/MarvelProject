package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MarvelHeroResponses
import com.example.myapplication.R
import com.example.myapplication.adapters.HeroesAdapter
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.db.AppDatabase
import com.example.myapplication.model.Characters
import com.example.myapplication.repository.Repository
import com.example.myapplication.utils.Resource
import com.example.myapplication.viewmodel.HeroesViewModel
import com.example.myapplication.viewmodel.HeroesViewModelProviderFactory

class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var binding: ActivityHomeBinding
    private lateinit var heroesAdapter : HeroesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = Repository(AppDatabase(this))
        val heroesModelProvider = HeroesViewModelProviderFactory(repository)

        viewModel = ViewModelProvider(this, heroesModelProvider)
            .get(HeroesViewModel::class.java)

        setUpRecyclerView()










    }

    private fun hideProgressBar(){

        binding.progressBar.visibility = View.INVISIBLE

    }

    private fun showProgressBar(){
       binding.progressBar.visibility = View.VISIBLE
    }

    private fun setUpRecyclerView(){
        heroesAdapter= HeroesAdapter()
        binding.recyclerview.apply {
            adapter = heroesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}