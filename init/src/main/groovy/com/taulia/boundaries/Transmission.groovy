package com.taulia.boundaries


class Transmission {

  Gear gear
  Moveable moveable

  Transmission(Moveable moveable){
    this.moveable = moveable
  }

  void shift(Gear gear) {
    if (canShiftToGear(gear)) {
      this.gear = gear
    }
  }

  private boolean canShiftToGear(Gear gear) {
    this.gear != gear && moveable.currentSpeedInMph() == 0
  }

}
