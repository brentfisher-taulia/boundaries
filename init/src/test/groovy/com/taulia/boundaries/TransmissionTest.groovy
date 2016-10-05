package com.taulia.boundaries

import org.junit.Before
import org.junit.Test


class TransmissionTest {
  private Transmission transmission;
  private Car car;

  @Before
  public void create() {
    car = new Car();
    transmission = new Transmission(car);
  }

  @Test
  public void remainsInDriveAfterAcceleration() {
    transmission.shift(Gear.DRIVE);
    car.accelerateTo(35);
    assertThat(transmission.getGear(), equalTo(Gear.DRIVE));
  }





  @Test
  public void ignoresShiftToParkWhileInDrive() {
    transmission.shift(Gear.DRIVE);
    car.accelerateTo(30);

    transmission.shift(Gear.PARK);

    assertThat(transmission.getGear(), equalTo(Gear.DRIVE));
  }

  @Test
  public void allowsShiftToParkWhenNotMoving() {
    transmission.shift(Gear.DRIVE);
    car.accelerateTo(30);
    car.brakeToStop();

    transmission.shift(Gear.PARK);

    assertThat(transmission.getGear(), equalTo(Gear.PARK));
  }
}
