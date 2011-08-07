package org.grahambrooks

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class StateMachineSpec extends FlatSpec with ShouldMatchers {

  val initialState = new MachineState[Boolean]("initial", null)
  val machine = new StateMachine[Boolean](initialState, null)

  "A State Machine (when initialised)" should "has an initial state" in {
    machine.initialState should be (initialState)
  }

}