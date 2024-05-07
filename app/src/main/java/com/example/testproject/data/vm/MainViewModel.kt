package com.example.testproject.data.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.network.toilet.response.FetchToiletResponse
import com.example.testproject.data.repository.ToiletRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val ToiletRepository: ToiletRepository
): ViewModel() {

    private val _Fetch_toiletResponseList = MutableStateFlow<List<FetchToiletResponse>>(emptyList());


    init {

    }

    fun readToilet() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = ToiletRepository.readToilet()

//            ToiletRepository.readToilet().collect {
//                _toiletList.value = it
//            }
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