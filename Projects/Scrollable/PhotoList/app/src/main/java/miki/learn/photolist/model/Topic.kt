package miki.learn.photolist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val photoNumber: Int,
    @DrawableRes val image: Int
)
