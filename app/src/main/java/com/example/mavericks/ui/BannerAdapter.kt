package com.example.mavericks.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mavericks.R
import com.example.mavericks.state.BannerState
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.banner_item.view.*

class BannerAdapter(private val context: Context) : SliderViewAdapter<BannerAdapter.SliderAdapterVH>() {
    private var mSliderItems: MutableList<BannerState> = ArrayList()

    fun addItem(sliderItem: BannerState) {
        mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH = SliderAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.banner_item, null))

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem: BannerState = mSliderItems[position]
        Glide.with(context)
                .load(sliderItem.imageURL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.image)
    }

    override fun getCount() = mSliderItems.size

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        var image: ImageView = itemView.iv_auto_image_slider
    }
}