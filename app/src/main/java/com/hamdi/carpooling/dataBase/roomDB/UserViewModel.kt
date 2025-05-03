package com.hamdi.carpooling.dataBase.roomDB

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.dataBase.remote.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository,
    private val roomRepository: RoomUserRepository
) : ViewModel() {

//    private val _users = MutableLiveData<List<User>>()
//    val users: LiveData<List<User>> = _users

    private fun fetchAndStoreRemoteUsers() {
        viewModelScope.launch {
            repository.fetchAndStoreRemoteUsers()
            //_users.value = roomRepository.getAllRoomUsers()
        }
    }

    init {
        fetchAndStoreRemoteUsers()
    }
}