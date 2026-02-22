package com.example.badroidtips.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val day: Int,
    @StringRes val titleRes: Int,
    @StringRes val shortTextRes: Int,
    @StringRes val fullTextRes: Int,
    @DrawableRes val imageRes: Int
)
