package com.example.core.states

sealed class NetworkState<out R> {
    data class Success<out T>(val data: T? = null) : NetworkState<T>()
    data class Error(val errorCode: Int, val message: String) : NetworkState<Nothing>()
}