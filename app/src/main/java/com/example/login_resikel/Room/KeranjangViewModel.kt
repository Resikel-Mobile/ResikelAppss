package com.example.login_resikel.Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class KeranjangViewModel(private val repository: KeranjangRepository) : ViewModel() {

    private val _totalQty = MutableLiveData<Int>()
    val totalQty: LiveData<Int> = _totalQty

    fun addItem(item: Keranjang) {
        viewModelScope.launch {
            repository.addOrUpdateItem(item)
        }
    }

    fun deleteItem(item: Keranjang) {
        viewModelScope.launch {
            repository.deleteOrUpdateItem(item)
        }
    }

    fun fetchTotalQty() {
        viewModelScope.launch {
            _totalQty.value = repository.getTotalQuantity()
        }
    }
}
