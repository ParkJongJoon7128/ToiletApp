package com.example.testproject

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.testproject.data.vm.MainViewModel
import com.example.testproject.ui.screens.MainScreen
import com.example.testproject.ui.theme.TestProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private val toiletViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestProjectTheme {
                MainScreen(vm = toiletViewModel)
            }
        }
    }
}