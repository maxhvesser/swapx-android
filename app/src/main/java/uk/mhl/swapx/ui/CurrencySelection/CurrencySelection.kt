package uk.mhl.swapx.ui.CurrencySelection

import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import uk.mhl.swapx.R
import uk.mhl.swapx.ui.theme.SwapTheme

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
                        painter = painterResource(R.drawable.ic_swap),
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        val padding = it


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