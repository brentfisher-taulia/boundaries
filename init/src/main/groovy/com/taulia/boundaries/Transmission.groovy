package com.taulia.boundaries


class Transmission {
  Car car
  Gear gear
  public Transmission(Car car){
    this.car == car
  }

  def shift(Gear gear) {
    this.gear = gear
  }
}
