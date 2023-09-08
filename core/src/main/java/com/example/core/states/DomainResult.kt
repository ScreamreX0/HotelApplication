package com.example.core.states

sealed class DomainResult<out R> {
    data class Success<out T>(val data: T? = null) : DomainResult<T>()
    data class Error(val errorCause: ErrorCause, var userFriendlyMessage: String) : DomainResult<Nothing>()
    data object Loading : DomainResult<Nothing>()
}

enum class ErrorCause {
    CONNECTION_LOST,
}