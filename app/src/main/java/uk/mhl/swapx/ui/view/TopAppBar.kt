package uk.mhl.swapx.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import uk.mhl.swapx.ui.theme.SwapTheme

// region Colors

@Composable
private fun standardAppBarColors() = TopAppBarDefaults.smallTopAppBarColors(
    containerColor = MaterialTheme.colorScheme.background,
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
    actions: @Composable RowScope.() -> Unit = { }
) {
    val barPadding = WindowInsets.statusBars.asPaddingValues()

    SmallTopAppBar(
        modifier = Modifier.padding(barPadding),
        title = { Text(title) },
        colors = standardAppBarColors(),
        navigationIcon = navigationIcon,
        actions = actions
    )
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