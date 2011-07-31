package org.grahambrooks

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class CircuitBreakerSpec extends FlatSpec with ShouldMatchers {

  val breaker = new CircuitBreaker

  "A Circuit Breaker (when initialised)" should "be closed" in {
    breaker should be('closed)
  }

  "A Circuit Breaker (when called)" should "delegate to implementation" in {
    breaker.execute(_ => {true})
    breaker should be('closed)
  }
}