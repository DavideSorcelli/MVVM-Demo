package com.dsorcelli.mvvmapp.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsorcelli.mvvmapp.data.Quote
import com.dsorcelli.mvvmapp.data.QuoteRepository

class QuotesViewModel(private val quoteRepo: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepo.getQuotes()

    fun addQuote(quote: Quote) = quoteRepo.addQuote(quote)


    /* FACTORY */
    @Suppress("UNCHECKED_CAST")
    class QuotesViewModelFactory(private val quoteRepo: QuoteRepository)
        : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return QuotesViewModel(quoteRepo) as T
        }
    }
}