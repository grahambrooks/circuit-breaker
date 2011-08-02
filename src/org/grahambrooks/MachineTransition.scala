package org.grahambrooks

class MachineTransition[T](condition: (T) => Boolean, finalState: MachineState[T], action: () => Any) {
  def isAcceptable(value: T): Boolean = {
    condition(value)
  }

  def execute() : MachineState[T] = {
    action()
    finalState
  }
}