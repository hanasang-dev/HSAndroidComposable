package dev.hanasang.android.composable.component

import android.widget.Button
import androidx.compose.runtime.Composable
import dev.hanasang.android.composable.decorator.DebounceDecorator

@Composable
fun BaseButton(onClick: () -> Unit) {
    val debounceDecorator = DebounceDecorator<Button>()
    val debounceDecorator2 = DebounceDecorator<Button>()

//    val result = debounceDecorator.execute(
//        debounceDecorator2.execute {
//            onClick()
//        })(Unit)
//
    val result = debounceDecorator.execute { t ->

    }
}