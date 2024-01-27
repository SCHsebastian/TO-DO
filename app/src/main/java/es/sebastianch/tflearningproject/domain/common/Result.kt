package es.sebastianch.tflearningproject.domain.common

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: UseCaseException) : Result<Nothing>()
}