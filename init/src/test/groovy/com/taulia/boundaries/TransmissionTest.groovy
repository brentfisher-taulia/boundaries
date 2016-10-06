package com.taulia.boundaries

import org.junit.Before
import org.junit.Test

class TransmissionTest {

  private Transmission transmission
  private Car car

  @Before
  public void create() {
    car = new Car()
    transmission = new Transmission(car)
  }

  @Test
  void allowsShiftToDriveWhenNotMoving() {

    transmission.shift(Gear.DRIVE)

    assert transmission.getGear() == Gear.DRIVE
  }

  @Test
  public void remainsInDriveAfterAcceleration() {
    transmission.shift(Gear.DRIVE)
    car.accelerateTo(35)
    assert transmission.getGear() == Gear.DRIVE
  }

  @Test
  void ignoresShiftToParkWhenMoving() {
    transmission.shift(Gear.DRIVE)
    car.accelerateTo(30)

    transmission.shift(Gear.PARK)

    assert transmission.getGear() == Gear.DRIVE
  }

  @Test
  public void allowsShiftToParkWhenNotMoving() {
    transmission.shift(Gear.DRIVE)
    car.accelerateTo(30)
    car.brakeToStop()

    transmission.shift(Gear.PARK)

    assert transmission.getGear() == Gear.PARK
  }

  @Test
  void repeatShiftToParkDoesNothing() {

    transmission.shift(Gear.PARK)
    transmission.shift(Gear.PARK)

    assert transmission.gear == Gear.PARK
  }

  @Test
  void repeatShiftToDriveDoesNothing() {

    transmission.shift(Gear.DRIVE)
    transmission.shift(Gear.DRIVE)

    assert transmission.gear == Gear.DRIVE
  }

}
