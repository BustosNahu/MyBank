package com.example.mybank.presentation.main.home

import com.example.mybank.R
import com.example.mybank.core.navigation.ScreenRoutes

sealed class InteractiveItems(
    val route: String,
    val title: String,
    val icon: Int,
) {
    data object QrPay : InteractiveItems(
        route = "", // TODO: Here should be the route for this item
        title = "Pay with Qr",
        icon = R.drawable.qr_code_icon,
    )

    data object Transfer : InteractiveItems(
        route = "", // TODO: Here should be the route for this item
        title = "Transfer Money",
        icon = R.drawable.transfer_money_icon,
    )

    data object Deposit : InteractiveItems(
        route = "", // TODO: Here should be the route for this item
        title = "Deposit Money",
        icon = R.drawable.deposit_money_icon,
    )

    data object PayTaxes : InteractiveItems(
        route = "", // TODO: Here should be the route for this item
        title = "Pay Taxes",
        icon = R.drawable.taxes_icon,
    )

    data object InsuranceAndGuarantee : InteractiveItems(
        route = "", // TODO: Here should be the route for this item
        title = "Insurance and Guarantee",
        icon = R.drawable.secure_icon,
    )

    data object AskForMoney : InteractiveItems(
        route = "", // TODO: Here should be the route for this item
        title = "Ask For Money",
        icon = R.drawable.recive_money_icon,
    )

}