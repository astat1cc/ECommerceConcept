package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.presentation.fragments.cart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.astat1cc.sergeybalakintesttask.core.utils.FetchResult
import com.github.astat1cc.sergeybalakintesttask.core.utils.UiState
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities.Basket
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.usecases.GetCartUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(
    private val getCartUseCase: GetCartUseCase,
    private val dispatcherIo: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    private val _cartItems = MutableLiveData<List<Basket>>()
    private val _total = MutableLiveData<Int>()
    private val _delivery = MutableLiveData<String>()

    val uiState: LiveData<UiState> = _uiState
    val cartItems: LiveData<List<Basket>> = _cartItems
    val total: LiveData<Int> = _total
    val delivery: LiveData<String> = _delivery

    init {
        getCart()
    }

    private fun getCart() {
        _uiState.postValue(UiState.Loading)
        viewModelScope.launch(dispatcherIo) {
            val cartCallResult = getCartUseCase.execute()
            if (cartCallResult is FetchResult.Success) {
                _cartItems.postValue(cartCallResult.data.basket)
                _total.postValue(cartCallResult.data.total)
                _delivery.postValue(cartCallResult.data.delivery)

                _uiState.postValue(UiState.Success)
            } else {
                _uiState.postValue(UiState.Error)
            }
        }
    }

    fun retryNetworkCall() {
        getCart()
    }
}