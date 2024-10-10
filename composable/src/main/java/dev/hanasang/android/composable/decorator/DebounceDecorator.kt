package dev.hanasang.android.composable.decorator

class DebounceDecorator<T>(
    private val debounceTime: Long = 1000L
) : BaseDecorator<T> {
    private var lastExecutionTime = 0L
    override fun execute(action: (T) -> Unit): (T) -> DecoratorResult = { param ->
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastExecutionTime > debounceTime) {
            lastExecutionTime = currentTime
            action(param)
            DecoratorResult.SUCCESS
        } else {
            DecoratorResult.DEBOUNCE_FAILURE
        }
    }
}