package com.taulia.boundaries


class Transmission {
  Car car
  Gear gear
  public Transmission(Car car){
    this.car = car
    this.gear = Gear.PARK
  }

  def shift(Gear gear) {
    if(this.gear == Gear.DRIVE && car.velocity==0){
      this.gear = gear
    }

  }
}
