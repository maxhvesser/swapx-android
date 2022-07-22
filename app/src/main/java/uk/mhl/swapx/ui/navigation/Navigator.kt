package uk.mhl.swapx.ui.navigation

import androidx.navigation.NavHostController

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

    val openCurrencySelection: () -> Unit = {
        navController.navigate(Destinations.CurrencySelection.Route)
    }

    // endregion

}