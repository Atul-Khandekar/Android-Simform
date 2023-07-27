package com.example.trainingproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.models.ShoppingListResponse
import com.example.trainingproject.repository.ShoppingListRepository
import kotlinx.coroutines.launch

class ShoppingListViewModel(private val shoppingListRepository: ShoppingListRepository) : ViewModel() {
    val _shoppingListResult: MutableLiveData<BaseResponse<ShoppingListResponse>> = MutableLiveData()
    fun getShoppingList() {
        viewModelScope.launch {
        _shoppingListResult.postValue(BaseResponse.Loading())
            try {
                val response = shoppingListRepository.getShoppingList()
                if (response.code() in 200..299) {
                    _shoppingListResult.postValue(BaseResponse.Success(response.body()))
                } else {
                    _shoppingListResult.postValue(BaseResponse.Error(response.message()))
                }
            } catch (e: Exception) {
                _shoppingListResult.postValue(BaseResponse.Error(e.message))
            }
        }
    }
}