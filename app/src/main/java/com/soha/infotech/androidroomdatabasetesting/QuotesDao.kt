package com.soha.infotech.androidroomdatabasetesting

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Step2: Create a DAO Interface to perform CURD operations
 */

@Dao
interface QuotesDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

   @Query("DELETE FROM quote")
    suspend fun delete()

    // Using LiveData
    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>

    // Using Flow
    @Query("SELECT * FROM quote")
    fun getQuotesFlow(): Flow<List<Quote>>


    @Query("SELECT * FROM quote where id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): Quote
}