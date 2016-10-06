package com.taulia.boundaries


class Car {
  int velocity

  def accelerateTo(int velocity) {
    this.velocity = velocity
  }

  def brakeToStop() {
    this.velocity = 0
  }
}
