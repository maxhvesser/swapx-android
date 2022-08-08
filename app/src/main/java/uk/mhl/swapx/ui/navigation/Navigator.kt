package uk.mhl.swapx.ui.navigation

import androidx.navigation.NavHostController
import uk.mhl.swapx.ui.model.ConversionDirection

class Navigator(navController: NavHostController) {

    // region Basic

    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }

    // endregion

    // region Exchange

    val openExchange: () -> Unit = {
        navController.navigate(Destinations.Exchange.Route)
    }

    // endregion


    // region Currency selection

    val openCurrencySelection: (ConversionDirection) -> Unit = { direction ->
        navController.navigate("${Destinations.CurrencySelection.Route}/$direction")
    }

    // endregion

}