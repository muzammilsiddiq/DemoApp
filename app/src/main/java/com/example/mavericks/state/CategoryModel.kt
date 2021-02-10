package com.example.mavericks.state

import android.os.Parcelable
import com.airbnb.mvrx.MavericksState
import kotlinx.android.parcel.Parcelize

data class CategoriesState(var isLoading: Boolean = false, val categories: List<CategoryState> = emptyList())

@Parcelize
data class CategoryState(val id: Int, val name: String, val menu: List<MenuModel> = emptyList()) : Parcelable