package uk.mhl.swapx.ui.util

import androidx.compose.foundation.lazy.LazyListState

val LazyListState.shouldLift: Boolean
    get() = firstVisibleItemScrollOffset > 0 || firstVisibleItemIndex > 0