package com.example.mavericks.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.example.mavericks.R
import com.example.mavericks.viewmodel.MenuViewModel
import kotlinx.android.synthetic.main.menu_fragment.*

class MenuFragment: Fragment(R.layout.menu_fragment), MavericksView {
    private val menuViewModel: MenuViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val animalNames: ArrayList<String> = ArrayList()
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")
        animalNames.add("Lorem Ipsum is simply dummy text of the printing and typesetting")

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MenuAdapter(context, animalNames)
    }

    override fun invalidate() {

    }
}