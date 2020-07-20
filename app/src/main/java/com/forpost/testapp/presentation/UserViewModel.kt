package com.forpost.testapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.forpost.testapp.domain.model.UserModel
import com.forpost.testapp.domain.usecase.UserListUseCase
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent


class UserViewModel(private val userUseCase: UserListUseCase) : ViewModel(), KoinComponent {

    companion object {
        private const val ERROR = "Error! = "
    }

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val usersData: MutableLiveData<List<UserModel>> = MutableLiveData()
    private val errorData: LiveEvent<String> = LiveEvent()
    val isLoad: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getUsers() {
        viewModelScope.launch {
            try {
                isLoad.postValue(true)
                userUseCase.getUsers().run {
                    usersData.postValue(this)
                    isLoad.postValue(false)
                }
            } catch (e: Exception) {
                errorData.postValue(ERROR + e.message)
                isLoad.postValue(true)
            }
        }
    }

    fun error() = errorData
}