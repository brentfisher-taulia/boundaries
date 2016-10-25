package com.taulia.boundaries


class Transmission {
  Gear gear
  Moveable moveable

  Transmission(Moveable moveable) {
    this.moveable = moveable
  }

  def shift(Gear gear) {
    if (this.gear == Gear.DRIVE && this.moveable.currentSpeedInMph() != 0 && gear == Gear.PARK) {
      return
    }
    this.gear = gear
  }
}
