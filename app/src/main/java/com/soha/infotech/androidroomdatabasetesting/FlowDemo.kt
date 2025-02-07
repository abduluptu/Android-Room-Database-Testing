package com.soha.infotech.androidroomdatabasetesting

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

/**
 * Step5: create a class for Flow
 */

class FlowDemo {

    fun getFlow() = flow<Int> {
        emit(1)
        delay(2000)
        emit(2)
        delay(2000)
    }
}