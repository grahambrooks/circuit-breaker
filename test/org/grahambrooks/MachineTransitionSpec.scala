package org.grahambrooks

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MachineTransitionSpec extends FlatSpec with ShouldMatchers {
  val finalState = new MachineState("final", List[MachineTransition[Boolean]]())
  var called = false
  val transition = new MachineTransition[Boolean]((x: Boolean) => x == true, finalState, () => called = true)

  "A Machine Transition (when initialised)" should "have accept events" in {
    transition.isAcceptable(true) should be(true)
    transition.isAcceptable(false) should be(false)
  }

  "Executing a transition" should "return final state" in {
    transition.execute() should be(finalState)
  }

  "Executing a transition" should "call action" in {
    called = false
    transition.execute()
    called should be(true)
  }
}
