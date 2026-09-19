package com.darusc.mousedroid.viewmodels

class XboxViewModel: BaseViewModel<XboxViewModel.State, XboxViewModel.Event>(State.Idle) {

    sealed class State : BaseViewModel.State() {
        object Idle : State()
    }

    sealed class Event : BaseViewModel.Event()
}