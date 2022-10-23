package uk.mhl.swapx.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.R
import uk.mhl.swapx.ui.theme.SwapTheme

// region Base Currency Card

@Composable
private fun BaseCurrencyCard(
    amount: String,
    currency: String,
    currencyCode: String,
    onCardClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onCardClicked() }
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = amount,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.secondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row {
            Text(
                text = "$currencyCode • $currency",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.75f)
            )
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.ic_chevron_right),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary.copy(alpha = 0.75f)
            )
        }
    }
}

// endregion

// region Currency Card

@Composable
fun CurrencyCard(
    amount: String,
    currency: String,
    currencyCode: String,
    onCardClicked: () -> Unit
) {
    BaseCurrencyCard(
        amount = amount,
        currency = currency,
        currencyCode = currencyCode,
        onCardClicked = onCardClicked
    )
}

// endregion

// region Preview

@Preview(showBackground = true)
@Composable
fun Preview_CurrencyCard() {
    SwapTheme {
        CurrencyCard(
            amount = "824.0",
            currency = "Canadian Dollars",
            currencyCode = "CAD",
            onCardClicked = { }
        )
    }
}

// endregion