package com.example.wishlistapp

import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishDao
import kotlinx.coroutines.flow.Flow

class Wishrepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWish()

    fun getAWishByID(id: Long): Flow<Wish> {
        return wishDao.getWishById(id)
    }

    suspend fun updateAWish(wish: Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteWish(wish)
    }

}