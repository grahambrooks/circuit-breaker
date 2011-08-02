package org.grahambrooks

class MachineState[T](_name: String, transitions: List[MachineTransition[T]]) {
  def accept(value: T): MachineState[T] = {
    var state = this
    transitions.foreach(t => {
      if (state == this && t.isAcceptable(value)) {
        state = t.execute()
      }
    })
    state
  }

  val name = this._name
}