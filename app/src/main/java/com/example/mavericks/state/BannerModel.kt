package com.example.mavericks.state

import com.airbnb.mvrx.MavericksState

// TODO: Need to assign Default Place Holder here
data class BannersState(val isLoading: Boolean = false, val banners: List<BannerState> = emptyList())
data class BannerState(val id: Int = 0, var imageURL: String = "", var caption: String = "")