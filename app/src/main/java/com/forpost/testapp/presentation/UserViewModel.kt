package com.forpost.testapp.presentation

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.ObservableInt
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
    private val usersData: MutableLiveData<List<UserModel>> = MutableLiveData()
    private val errorData: LiveEvent<String> = LiveEvent()
    val isLoad: ObservableInt = ObservableInt(GONE)

    fun getUsers() {
        viewModelScope.launch {
            try {
                isLoad.set(VISIBLE)
                userUseCase.getUsers().run {
                    usersData.value = this
                    isLoad.set(GONE)
                }
            } catch (e: Exception) {
                errorData.postValue(ERROR + e.message)
                isLoad.set(GONE)
            }
        }
    }

    fun userData() = usersData
    fun error() = errorData
}