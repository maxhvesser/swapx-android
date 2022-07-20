package uk.mhl.swapx.ui.util

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBackDispatcher = staticCompositionLocalOf<OnBackPressedDispatcher> {
    error("No Back Dispatcher provided")
}