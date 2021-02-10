package com.example.mavericks.viewmodel

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.mavericks.repositories.DataSource
import com.example.mavericks.repositories.MockDataSource
import com.example.mavericks.state.CategoriesState
import io.reactivex.Observable

class CategoryViewModel(categoriesStateInitialState: CategoriesState, private val dataSources: List<DataSource>) : BaseMvRxViewModel<CategoriesState>(categoriesStateInitialState) {

    init {
        getCategories()
    }

    fun getCategories() {
        Observable.merge(dataSources.map { it.getCategoriesState().toObservable() })
                .doOnSubscribe { setState { copy(isLoading = true) } }
                .doOnComplete { setState { copy(isLoading = false) } }
                .execute {
                    copy(isLoading = isLoading, categories = it()?.categories ?: categories)
                }
    }

    fun getBanners() {
        Observable.merge(dataSources.map { it.getBannersState().toObservable() })
                .doOnSubscribe { setState { copy(isLoading = true) } }
                .doOnComplete { setState { copy(isLoading = false) } }
                .execute {
                    copy(isLoading = isLoading, categories = it()?.categories ?: categories)
                }
    }

    companion object : MavericksViewModelFactory<CategoryViewModel, CategoriesState> {

        override fun create(viewModelContext: ViewModelContext, state: CategoriesState): CategoryViewModel {
            //TODO: Currently we're not supporting other data source so just commented out
            // val remoteDataSource: DataSource = RemoteDataSource()
            // val localDataSource: DataSource = LocalDataSource()
            val mockDataSource: DataSource = MockDataSource()
            return CategoryViewModel(state, listOf(mockDataSource))
        }
    }
}
