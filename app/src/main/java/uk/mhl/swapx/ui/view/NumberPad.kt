package uk.mhl.swapx.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.R
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.util.NavigationBarSpacer

// region Key Types

enum class Key(
    val display: String
) {
    Seven("7"),
    Eight("8"),
    Nine("9"),
    Four("4"),
    Five("5"),
    Six("6"),
    One("1"),
    Two("2"),
    Three("3"),
    Zero("0"),
    Decimal("."),
    Backspace("")
}

// endregion

// region Base Keys

@Composable
private fun BaseNumberKey(
    number: String,
    onKeyClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.surface)
            .height(64.dp)
            .fillMaxWidth()
            .clickable { onKeyClicked() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun BaseIconKey(
    iconPainter: Painter,
    onKeyClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
            .height(64.dp)
            .fillMaxWidth()
            .clickable { onKeyClicked() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = null
        )
    }
}

// endregion

// region Standard Keys

@Composable
private fun NumberKey(
    key: Key,
    onKeyClicked: (Key) -> Unit
) {
    BaseNumberKey(
        number = key.display,
        onKeyClicked = { onKeyClicked(key) }
    )
}

@Composable
private fun IconKey(
    key: Key,
    iconPainter: Painter,
    onKeyClicked: (Key) -> Unit
) {
    BaseIconKey(
        iconPainter = iconPainter,
        onKeyClicked = { onKeyClicked(key) }
    )
}

// endregion

// region Number Pad

@Composable
fun NumberPad(
    onKeyClicked: (Key) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 12.dp,
                end = 12.dp,
                bottom = 12.dp
            ),
            userScrollEnabled = false
        ) {
            items(Key.values()) { key ->
                if (key == Key.Backspace) {
                    IconKey(
                        key = key,
                        iconPainter = painterResource(R.drawable.ic_backspace),
                        onKeyClicked = onKeyClicked
                    )
                } else {
                    NumberKey(
                        key = key,
                        onKeyClicked = onKeyClicked
                    )
                }
            }

            item {
                NavigationBarSpacer()
            }
        }
    }
}

// endregion

// region Preview

@Preview
@Composable
fun Preview_NumberPad() {
    SwapTheme {
        NumberPad(
            onKeyClicked = { }
        )
    }
}

// endregion