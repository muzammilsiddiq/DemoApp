package com.example.mavericks.state

import com.airbnb.mvrx.MavericksState

data class MenuModel(val id: Int = 0, val categoryId: Int, val name: String = "", val description: String = "", val otherInfo: String, val imageURL: String = "") : MavericksState