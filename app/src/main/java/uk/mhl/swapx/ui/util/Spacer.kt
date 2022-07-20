package uk.mhl.swapx.ui.util

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// region Insets

@Composable
fun NavigationBarSpacer() {
    Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
}

// endregion