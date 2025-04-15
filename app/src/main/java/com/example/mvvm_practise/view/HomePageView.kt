package com.example.mvvm_practise.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mvvm_practise.viewModel.UserViewModel


@Composable
fun HomePageView(modifier: Modifier, viewModel: UserViewModel){

    val userData = viewModel.userData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()

    Column(modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally) {

        Button( onClick = { viewModel.getUserData() }) {
            Text(text = "Get User Data")
        }
        if(isLoading.value == true){
           CircularProgressIndicator()
        }else{
            userData.value?.name.let {
                Text(text = "Name : $it")
            }
            userData.value?.age.let {
                Text(text = "Age : $it")
            }
        }

    }
}