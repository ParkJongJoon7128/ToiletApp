package com.example.testproject.data.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.common.APIResponse
import com.example.testproject.network.toilet.response.FetchToiletResponse
import com.example.testproject.data.repository.ToiletRepository
import com.example.testproject.network.toilet.response.ToiletData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val ToiletRepository: ToiletRepository
) : ViewModel() {

    private val _toiletResponseList = MutableStateFlow<List<ToiletData>>(emptyList());


    val toiletResponseList = _toiletResponseList.asStateFlow()

    init {
        readToilet()
    }

    fun readToilet() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = ToiletRepository.readToilet()

            when(result){
                is APIResponse.Success -> {
                    _toiletResponseList.emit(result.data!!.data)
                    Log.d("readToilet", "readToilet: ${result.data.data}")
                }
                is APIResponse.Error -> {
                    Log.d("readToilet", "readToilet: ${result.message}")
                }
            }
        }
    }


//    private val _email =  MutableStateFlow("")
//    private val _password = MutableStateFlow("")
//    private val _autoLoginClicked = MutableStateFlow(false)
//    private val _pwdVisibilityClicked = MutableStateFlow(false)
//
//    val email: StateFlow<String> = _email.asStateFlow()
//    val password: StateFlow<String> = _password.asStateFlow()
//    val autoLoginClicked: StateFlow<Boolean> = _autoLoginClicked.asStateFlow()
//    val pwdVisibilityClicked: StateFlow<Boolean> = _pwdVisibilityClicked.asStateFlow()
//
//    fun setEmail(email: String) {
//        _email.value = email
//    }
//
//    fun setPassWord(password: String) {
//        _password.value = password
//    }
//
//    fun setAutoLoginClicked() {
//        _autoLoginClicked.value = !_autoLoginClicked.value
//    }
//
//    fun setPwdVisibilityClicked() {
//        _pwdVisibilityClicked.value = !_pwdVisibilityClicked.value
//    }
}