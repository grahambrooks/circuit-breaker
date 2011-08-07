package org.grahambrooks

class StateMachine[T](_initialState: MachineState[T], states: List[MachineState[T]]) {
  val initialState = _initialState
}