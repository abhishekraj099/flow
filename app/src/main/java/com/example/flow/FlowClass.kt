package com.example.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main(){
  runBlocking {
     testFlow().filter {
         it.contains("API") // flatMapConcat work as map but we can return multiple values in it and also it will return a flow
     }.map { // flatMaplatest work as map but we can return multiple values in it and also it will return a flow
         it+"this"
     } .collect{
         println(it)
     }
  }
}

fun testFlow() = flow<String> {
    emit("start API Calling ")
    delay(3000)
    emit("Data Got")
    delay(2000)
    emit("Data Filtering")
    delay(1000)
    emit("Data Return")
}