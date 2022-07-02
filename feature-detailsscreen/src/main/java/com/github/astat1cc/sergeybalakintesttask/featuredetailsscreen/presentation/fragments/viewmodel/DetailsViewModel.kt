package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.presentation.fragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities.ProductDetails
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.usecases.GetProductDetailsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val dispatcherIo: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _productDetails = MutableLiveData<ProductDetails>()

    val productDetails: LiveData<ProductDetails> = _productDetails

    init {
        getDetails()
    }

    private fun getDetails() {
        viewModelScope.launch(dispatcherIo) {
            val productDetails = getProductDetailsUseCase.execute()
            _productDetails.postValue(productDetails)
        }
    }
}