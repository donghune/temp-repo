package com.dragonsnest.presenter.main

import androidx.lifecycle.viewModelScope
import com.dragonsnest.domain.entity.UserEntity
import com.dragonsnest.domain.repository.UserRepository
import com.dragonsnest.presenter.DragonNestViewModel
import com.dragonsnest.presenter.ViewCommand
import com.dragonsnest.presenter.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : DragonNestViewModel<MainViewModel.Command>() {

    private val mutableUserList = MutableStateFlow(listOf<UserEntity>())
    val userList: StateFlow<List<UserEntity>>
        get() = mutableUserList

    fun fetchUser() {
        viewModelScope.launch {
            userRepository.fetchUsers()
                .onStart { updateViewState(ViewState.Loading) }
                .onEach { mutableUserList.value = it.toList() }
                .onCompletion { updateViewState(ViewState.Complete) }
                .catch { updateViewState(ViewState.Error(it)) }
                .collect()
        }
    }

    class Command : ViewCommand
}
