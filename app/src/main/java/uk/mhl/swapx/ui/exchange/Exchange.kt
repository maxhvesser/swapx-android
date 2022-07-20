package uk.mhl.swapx.ui.exchange

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.mhl.swapx.ui.view.NumberPad

@Composable
fun Exchange() {
    Column {
        Spacer(Modifier.weight(1f))
        NumberPad(
            onKeyClicked = { }
        )
    }
}