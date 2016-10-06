package com.taulia.boundaries


class Car implements Moveable{
  int mph

  @Override
  int currentSpeedInMph() {
    mph
  }

  void accelerateTo(int mph){
    this.mph = mph
  }
  void brakeToStop(){
    mph = 0
  }
}
