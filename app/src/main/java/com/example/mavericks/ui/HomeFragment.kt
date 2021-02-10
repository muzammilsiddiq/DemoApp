package com.example.mavericks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.example.mavericks.R
import com.example.mavericks.state.BannerState
import com.google.android.material.tabs.TabLayoutMediator
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import kotlinx.android.synthetic.main.fragment_parallex.*

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_parallex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabBar.addTab(tabBar.newTab().setText("Home"))
        tabBar.addTab(tabBar.newTab().setText("Sport"))
        tabBar.addTab(tabBar.newTab().setText("Movie"))
        tabBar.addTab(tabBar.newTab().setText("Movie"))
        tabBar.addTab(tabBar.newTab().setText("Movie"))
        tabBar.addTab(tabBar.newTab().setText("Movie"))
        tabBar.addTab(tabBar.newTab().setText("Movie"))
        tabBar.addTab(tabBar.newTab().setText("Movie"))

//        childFragmentManager.beginTransaction().replace(R.id.container, CounterFragment()).commit()

//        tabBar.setup(viewPager)
        viewPager.adapter = ScreenSlidePagerAdapter(requireActivity())
        viewPager.orientation = ORIENTATION_HORIZONTAL
        TabLayoutMediator(tabBar, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = "Test $position"
        }).attach()
        setUpBanners()
        setupTabView()
    }

    private fun setupTabView() {
//        for (i in 0 until tabBar.tabCount) {
//            tabBar.getTabAt(i)?.setCustomView(R.layout.custom_tab)
//            val tvTitle = tabBar.getTabAt(i)?.customView?.findViewById<TextView>(R.id.tvTitle)
//            tvTitle?.text = tabBar.getTabAt(i)?.text
//        }
    }

    private fun setUpBanners() {
        val adapter = BannerAdapter(requireContext())
        adapter.addItem(BannerState(1, "https://i2.wp.com/www.eatthis.com/wp-content/uploads/2018/05/mcdonalds-burger-fries-soda.jpg?fit=1024%2C750&ssl=1", ""))
        adapter.addItem(BannerState(1, "https://www.qsrmagazine.com/sites/default/files/slideshow-images/slides/mcdonaldsglobal.jpg", ""))
        adapter.addItem(BannerState(1, "https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/quizzes/fast_food_smarts_rmq/650x350_fast_food_smarts_rmq.jpg", ""))
        adapter.addItem(BannerState(1, "https://assets.aboutkidshealth.ca/AKHAssets/fast_food_better_choices.jpg?renditionid=21", ""))
        adapter.addItem(BannerState(1, "https://blog.e360.pk/wp-content/uploads/2020/01/best-fast-food.jpg", ""))
        adapter.addItem(BannerState(1, "https://i2.wp.com/www.eatthis.com/wp-content/uploads/2018/05/mcdonalds-burger-fries-soda.jpg?fit=1024%2C750&ssl=1", ""))
        adapter.addItem(BannerState(1, "https://i2.wp.com/www.eatthis.com/wp-content/uploads/2018/05/mcdonalds-burger-fries-soda.jpg?fit=1024%2C750&ssl=1", ""))
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.DROP)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.startAutoCycle()
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 10

        override fun createFragment(position: Int): Fragment = MenuFragment()
    }
}