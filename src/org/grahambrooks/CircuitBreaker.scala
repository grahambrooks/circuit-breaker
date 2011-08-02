package org.grahambrooks

class CircuitBreaker {
  def execute(function:() => Boolean) :Boolean = {
    function()
  }

  def closed = true
}