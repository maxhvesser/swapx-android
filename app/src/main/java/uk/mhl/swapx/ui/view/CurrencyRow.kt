package uk.mhl.swapx.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

// region Base row

@Composable
private fun BaseCurrencyRow(
    icon: Painter,
    currency: String,
    currencyCode: String,
    selected: Boolean,
    onRowClicked: () -> Unit
) {
    val backgroundColor = if (selected) {
        MaterialTheme.colorScheme.secondaryContainer
    } else {
        MaterialTheme.colorScheme.surface
    }

    val foregroundColor = if (selected) {
        MaterialTheme.colorScheme.onSecondaryContainer
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
            .clickable { onRowClicked() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null
        )
        Text(
            text = currency,
            style = MaterialTheme.typography.labelLarge,
            color = foregroundColor
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = currencyCode,
            style = MaterialTheme.typography.titleMedium,
            color = foregroundColor
        )
    }
}

// endregion

// region Row

@Composable
fun CurrencyRow(
    currencyIcon: Painter,
    currency: String,
    currencyCode: String,
    selected: Boolean,
    onRowClicked: () -> Unit
) {
    BaseCurrencyRow(
        icon = currencyIcon,
        currency = currency,
        currencyCode = currencyCode,
        selected = selected,
        onRowClicked = onRowClicked
    )
}

// endregion

// region Preview

@Preview
@Composable
fun Preview_CurrencyRow() {
    SwapTheme {
        CurrencyRow(
            currencyIcon = painterResource(R.drawable.ic_chevron_right),
            currency = "Canadian Dollars",
            currencyCode = "CAD",
            selected = true,
            onRowClicked = { }
        )
    }
}

// endregion