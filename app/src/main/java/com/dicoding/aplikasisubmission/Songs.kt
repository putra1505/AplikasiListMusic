package com.dicoding.aplikasisubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Songs(
    val name: String,
    val description: String,
    val photo: Int,
    val Artist: String,
    val Producer: String
) : Parcelable
