package com.example.mvvmretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofit.models.QuoteList
import com.example.mvvmretrofit.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//MainViewModel will hold the reference of repository
class MainViewModel(private val repository: QuoteRepository) : ViewModel(){
    //(private val repository: QuoteRepository)==MainViewModel will need the access of repository

    init {
      // Whenever the MainViewModel will get load, it will send the request to repository to get the quotes(data)
       viewModelScope.launch(Dispatchers.IO){

           repository.getQuotes(1)

       }
    }

    val quotes : LiveData<QuoteList>
    get() =  repository.quotes //getter property to point the repository's live data so that we can give it to activity





}