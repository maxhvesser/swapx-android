package uk.mhl.swapx.ui.CurrencySelection

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.R
import uk.mhl.swapx.data.local.CurrencyListProvider
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.view.CurrencyRow

// region Entry

@Composable
fun CurrencySelection() {
    Content()
}

// endregion

// region Content

@Composable
private fun Content() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text("Currency")
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(12.dp, 0.dp),
                        painter = painterResource(R.drawable.ic_arrow_back),
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        val padding = it

        CurrencyList()
    }
}

@Composable
private fun CurrencyList() {
    val currencies = CurrencyListProvider().currencies()
    
    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {
        items(currencies) { currency ->
            CurrencyRow(
                currency = currency.name,
                currencyCode = currency.code,
                currencyIcon = painterResource(currency.iconAsset),
                selected = currency.code == "CAD",
                onRowClicked = { }
            )
        }
    }
}

// endregion

// region Preview

@Preview(showBackground = true)
@Composable
fun Preview_Content() {
    SwapTheme {
        Content()
    }
}

// endregion