package uk.mhl.swapx.ui.view

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.ui.theme.SwapTheme

// region Colors

@Composable
private fun standardAppBarColors() = TopAppBarDefaults.smallTopAppBarColors(
    containerColor = MaterialTheme.colorScheme.surface,
    navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
    titleContentColor = MaterialTheme.colorScheme.onBackground,
    actionIconContentColor = MaterialTheme.colorScheme.onBackground
)

// endregion

// region Top App Bar

@Composable
fun SwapAppBar(
    title: String,
    navigationIcon: @Composable () -> Unit = { },
    actions: @Composable RowScope.() -> Unit = { },
    shouldLift: Boolean = false
) {
    Surface(
        tonalElevation = if (shouldLift) 2.dp else 0.dp
    ) {
        TopAppBar(
            title = { Text(title) },
            colors = standardAppBarColors(),
            navigationIcon = navigationIcon,
            actions = actions,
        )
    }
}

// endregion

// region Navigation Icons

@Composable
private fun NavigationButton(
    onClick: () -> Unit,
    icon: ImageVector
) {
    IconButton(onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
    }
}

@Composable
fun BackArrowNavigation(onClick: () -> Unit) {
    NavigationButton(onClick, Icons.Outlined.ArrowBack)
}

// endregion

// region Preview

@Preview
@Composable
fun Preview_TopAppBars() {
    SwapTheme {
        SwapAppBar(
            title = "Swap App Bar",
            navigationIcon = { BackArrowNavigation(onClick = { }) }
        )
    }
}

// endregion