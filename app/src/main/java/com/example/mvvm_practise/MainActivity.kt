package com.example.mvvm_practise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_practise.ui.theme.MVVM_practiseTheme
import com.example.mvvm_practise.view.HomePageView
import com.example.mvvm_practise.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewmodel = ViewModelProvider(this)[UserViewModel::class.java]
        setContent {
            MVVM_practiseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePageView(Modifier.padding(innerPadding),
                       viewmodel)
                }
            }
        }
    }
}

