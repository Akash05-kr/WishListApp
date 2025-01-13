package com.example.wishlistapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.data.Wish
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class wishViewModel(
    private val wishRepository: Wishrepository = Graph.wishRepository
): ViewModel() {

    private val _wishList = MutableStateFlow(emptyList<Wish>())
    val wishList = _wishList.asStateFlow()

    var wishTitleState by mutableStateOf(" ")
    var wishDescriptionState by mutableStateOf(" ")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }
    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch{
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.addAWish(wish = wish)
        }
    }

    fun getWishById(id: Long): Flow<Wish>{
        return wishRepository.getAWishByID(id = id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.updateAWish(wish = wish)
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.deleteAWish(wish = wish)
        }
    }

}


















