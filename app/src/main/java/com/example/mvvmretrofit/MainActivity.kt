package com.example.mvvmretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofit.api.QuoteService
import com.example.mvvmretrofit.api.RetrofitHelper
import com.example.mvvmretrofit.repository.QuoteRepository
import com.example.mvvmretrofit.viewmodels.MainViewModel
import com.example.mvvmretrofit.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)
        mainViewModel= ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {

            var apiResult= it.results.toString()
            Log.d("ResultsInLog",apiResult)
            Toast.makeText(this@MainActivity, "$apiResult", Toast.LENGTH_LONG).show()

        })
    }
}