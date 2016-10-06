package com.taulia.boundaries


class Transmission {
  Gear gear
  Moveable moveable
  Transmission(Moveable moveable){
    this.moveable = moveable
  }
  def shift(Gear gear) {
    // begs for a state-machine implementation
    if (moveable.currentSpeedInMph() > 0 && gear == Gear.PARK) return;
    this.gear = gear;

  }
}
