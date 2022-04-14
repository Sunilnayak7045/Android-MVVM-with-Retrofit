package com.example.mvvmretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofit.api.QuoteService
import com.example.mvvmretrofit.models.QuoteList



//Repository will hold the reference of api/roomdb
class QuoteRepository(private val quoteService: QuoteService) {
// QuoteService will hit the api
//access the api through QuoteService OR reference of api
//QuoteService having interface in which methods are defined which will called a end point


    private val quotesLiveData = MutableLiveData<QuoteList>()  // MutableLiveData having type of QuoteList

    //publicly access live data
    val quotes: LiveData<QuoteList>  //alternate way //val quotes: LiveData<QuoteList> = quotesLiveData
    get() = quotesLiveData

    // this fun getQuotes() will be called by view-model
    suspend fun getQuotes(page: Int) {
        val result = quoteService.getQuotes(page)

        // check whether result that we get from api is null or not
        if(result?.body() != null){
            //Repository will fetch the data

                // set the response in quotesLiveData
            quotesLiveData.postValue(result.body())
        }
    }


}