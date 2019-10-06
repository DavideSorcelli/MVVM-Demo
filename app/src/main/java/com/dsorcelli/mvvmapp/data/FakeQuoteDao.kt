package com.dsorcelli.mvvmapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/*
    Data Access Object.
    Isolation layer to access database table,
    provide some specific data operations without exposing details of the db
 */

class FakeQuoteDao {

    private val quoteList = mutableListOf<Quote>() // persistent data
    private val quotes = MutableLiveData<List<Quote>>() // exposed data

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    /*  return LiveData because from outside you must only observe that data.
        only Dao class can modify list content
     */
    fun getQuotes(): LiveData<List<Quote>> = quotes

}