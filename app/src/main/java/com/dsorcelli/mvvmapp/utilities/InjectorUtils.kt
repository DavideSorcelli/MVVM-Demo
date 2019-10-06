package com.dsorcelli.mvvmapp.utilities

import com.dsorcelli.mvvmapp.data.FakeDatabase
import com.dsorcelli.mvvmapp.data.QuoteRepository
import com.dsorcelli.mvvmapp.ui.quotes.QuotesViewModel

/*
    Utility methods to provide instances of "dependencies"
    classes to our dependent classes.
    Easy to share the same class instance (QuoteRepository) between
    bunch of different classes (dependent classes)
 */

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModel.QuotesViewModelFactory {
        val quoteRepo = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModel.QuotesViewModelFactory(quoteRepo)
    }
}