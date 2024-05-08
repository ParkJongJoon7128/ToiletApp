package com.example.ToiletApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.ToiletApp.data.vm.MainViewModel
import com.example.ToiletApp.ui.screens.MainScreen
import com.example.ToiletApp.ui.theme.TestProjectTheme
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