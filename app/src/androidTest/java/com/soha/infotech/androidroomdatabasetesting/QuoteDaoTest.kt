package com.soha.infotech.androidroomdatabasetesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Step4: Create a test class for DAO & DB
 */

class QuotesDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

     lateinit var quoteDatabase: QuoteDatabase
     lateinit var quotesDao: QuotesDao

    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quotesDao = quoteDatabase.quoteDao()
    }


    @Test
    fun insertQuote_expectedSingleQuoteWithLiveData() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Soha Infotech")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes().getOrAwaitValue()

        assertEquals(1, result.size)
        assertEquals("This is a test quote", result[0].text)
    }

    @Test
     fun deleteQuote_expectedNoResults() = runBlocking {
         val quote = Quote(0, "This is a test quote", "Soha Infotech")
         quotesDao.insertQuote(quote)

         quotesDao.delete()

         val result = quotesDao.getQuotes().getOrAwaitValue()

         assertEquals(0, result.size)
     }


    @After
    fun tearDown() {
        quoteDatabase.close()
    }
}

