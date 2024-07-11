package miki.learn.accountingapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AccountingInfo(
    @StringRes val title: Int,
    @StringRes val text: Int,
    @DrawableRes val image: Int
)
