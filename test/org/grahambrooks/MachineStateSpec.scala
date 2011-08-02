package org.grahambrooks

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MachineStateSpec extends FlatSpec with ShouldMatchers {
  val trueState = new MachineState[Boolean]("foo", List[MachineTransition[Boolean]]())

  val trueTransition = new MachineTransition[Boolean]((x: Boolean) => x == true, trueState, () => true)

  val initialState = new MachineState[Boolean]("foo", List[MachineTransition[Boolean]](trueTransition))

  "A Machine State" should "have a name" in {
    initialState.name should be("foo")
  }

  "A Machine State" should "Accept input and call appropriate Transition" in {
    val s = initialState.accept(true)

    s should be(trueState)
  }

  "A Machine State" should "Ignore input that does not match a transition and return same state" in {
    initialState.accept(false) should be(initialState)
  }

  "A Machine State" should "Action the first matching transition" in {
    val firstState = new MachineState[Boolean]("foo", List[MachineTransition[Boolean]]())
    val firstTransition = new MachineTransition[Boolean]((x: Boolean) => x == true, firstState, () => true)
    val secondState = new MachineState[Boolean]("foo", List[MachineTransition[Boolean]]())
    val secondTransition = new MachineTransition[Boolean]((x: Boolean) => x == true, secondState, () => true)

    val initialState = new MachineState[Boolean]("foo", List[MachineTransition[Boolean]](firstTransition, secondTransition))

    initialState.accept(true) should be(firstState)
  }
}