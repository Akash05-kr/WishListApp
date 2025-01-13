package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase

object Graph {

    lateinit var database: WishDatabase

    val wishRepository by lazy {
        Wishrepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room
            .databaseBuilder(context = context,
                WishDatabase::class.java, "Wishlist.db").build()
    }


}