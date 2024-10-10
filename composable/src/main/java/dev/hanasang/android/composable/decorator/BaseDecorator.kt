package dev.hanasang.android.composable.decorator

enum class DecoratorResult {
    SUCCESS,
    DEBOUNCE_FAILURE
}

interface BaseDecorator<T> {
    fun execute(action: (T) -> Unit): (T) -> DecoratorResult
}