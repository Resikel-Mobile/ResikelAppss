package com.example.login_resikel.Room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class KeranjangViewModelFactory(private val repository: KeranjangRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KeranjangViewModel::class.java)) {
            return KeranjangViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}