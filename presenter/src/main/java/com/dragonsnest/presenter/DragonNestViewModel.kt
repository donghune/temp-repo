package com.dragonsnest.presenter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class ViewState {
    object None : ViewState()
    object Loading : ViewState()
    object Complete : ViewState()
    class Error(val throwable: Throwable) : ViewState()
}

interface ViewCommand

object NoneViewCommand : ViewCommand

abstract class DragonNestViewModel<VC : ViewCommand> : ViewModel() {

    private val mutableViewState = MutableStateFlow<ViewState>(ViewState.None)
    val viewState: StateFlow<ViewState> = mutableViewState

    private val mutableViewCommand = MutableStateFlow<ViewCommand>(NoneViewCommand)
    val viewCommand: StateFlow<ViewCommand> = mutableViewCommand

    protected fun updateViewState(viewState: ViewState) {
        mutableViewState.value = viewState
    }

    protected fun updateViewCommand(viewCommand: VC) {
        mutableViewCommand.value = viewCommand
    }
}
