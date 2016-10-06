package com.taulia.boundaries


class Transmission {
  Gear gear
  Moveable moveable
  Transmission(Moveable moveable){
    this.moveable = moveable
  }

  void shift(Gear g) {
    if (moveable.currentSpeedInMph() > 0) {
       this.gear = Gear.DRIVE
    } else { this.gear = g }

  }
}
