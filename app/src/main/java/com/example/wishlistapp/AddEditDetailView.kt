package com.example.wishlistapp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.compose.material.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wishlistapp.data.Wish
import kotlinx.coroutines.launch


@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: wishViewModel,
    navController: NavController
) {
        val snackMessage = remember {
            mutableStateOf("")
        }
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()
    if (id != 0L) {
       val wish= viewModel.getWishById(id = id)
           .collectAsState(initial = Wish(0L, "", ""))
            viewModel.wishTitleState = wish.value.title
            viewModel.wishDescriptionState = wish.value.description
    }else{
        viewModel.wishTitleState = ""
        viewModel.wishDescriptionState = ""
    }

   Scaffold(
       scaffoldState = scaffoldState,
       topBar = {
           AppBarView(
               title = if (id !=0L) stringResource(id = R.string.update_wish)
               else stringResource(id = R.string.add_wish)
           ){navController.navigateUp()}
         },
       )
   {
       Column(
           modifier = Modifier
               .padding(it)
               .wrapContentSize(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           Spacer(modifier = Modifier.height(10.dp))

           WishTextField(label = "Title",
               value = viewModel.wishTitleState,
               onValueChanged = { viewModel.onWishTitleChanged(it) })

           Spacer(modifier = Modifier.height(10.dp))

           WishTextField(label = "Description",
               value = viewModel.wishDescriptionState,
               onValueChanged = { viewModel.onWishDescriptionChanged(it) })

           Spacer(modifier = Modifier.height(10.dp))

           Button(onClick = {
                 if (viewModel.wishTitleState.isNotEmpty() &&
                         viewModel.wishDescriptionState.isNotEmpty()) {
                     if(id != 0L) {
                         // update wish
                         viewModel.updateWish(
                             Wish(
                                 id = id,
                                 title = viewModel.wishTitleState.trim(),
                                 description = viewModel.wishDescriptionState.trim()
                             )
                         )

                     }else{
                         // to add wish
                         viewModel.addWish(
                             Wish(
                                 title = viewModel.wishTitleState.trim(),
                                 description = viewModel.wishDescriptionState.trim()))
                         snackMessage.value = "Wish has been created successfully"
                     }
                         }else{
                             snackMessage.value = "Please fill all the fields to create a wish "
                 }
             scope.launch{
                 scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                 navController.navigateUp()
             }
           },
               modifier = Modifier.background(color = Color.Black).fillMaxWidth().padding(8.dp),
               shape = RoundedCornerShape(10.dp),
                colors= ButtonDefaults.buttonColors(backgroundColor = Color.Black),

               ) {
               Text(
                   text =
                   if (id != 0L) stringResource(id = R.string.update)
                   else stringResource(id = R.string.add),
                   style = TextStyle(fontSize = 18.sp),
                   color = Color.White
               )
           }
       }

   }
}

@Composable
fun WishTextField(
    label: String ,
    value: String,
    onValueChanged: (String) -> Unit
    ) {
    OutlinedTextField(value = value ,
        onValueChange= onValueChanged,
        label = { Text(text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            textColor = Color.Black,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black
        ))
    
}

























