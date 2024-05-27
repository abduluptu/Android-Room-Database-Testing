package com.soha.infotech.androidroomdatabasetesting

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class FlowDemoTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getFlowTest(): Unit = runTest {
        val sut = FlowDemo()
        val result = sut.getFlow().toList()
        Assert.assertEquals(listOf(1,2), result)
    }
}