package com.example.wishlistapp

import android.R.attr.navigationIcon
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.example.wishlistapp.R

@Composable
fun AppBarView(
               title: String,
               onBackNavClicked: ()-> Unit = {})
{
    val navigationIcon: (@Composable () -> Unit)? =
        if(!title.contains("WishList")){
            {
            IconButton(onClick = { onBackNavClicked() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            } }
        }else{
            null
        }




    TopAppBar( title = { Text( text = title, color = colorResource(R.color.white),
        modifier = Modifier.padding(start = 4.dp).heightIn(max= 32.dp))
    },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
        navigationIcon = navigationIcon

    )
}