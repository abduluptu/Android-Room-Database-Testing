package com.soha.infotech.androidroomdatabasetesting

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Step1: Create an data class Quote for Quote Table
 */

@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    val author: String
)
