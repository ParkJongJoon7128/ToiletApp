package com.example.ToiletApp.data.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ToiletApp.common.APIResponse
import com.example.ToiletApp.data.repository.ToiletRepository
import com.example.ToiletApp.network.toilet.response.ToiletData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
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
}