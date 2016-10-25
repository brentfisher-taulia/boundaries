package com.taulia.boundaries

import org.junit.Test


class BearingTest {
  @Test(expected = BearingOutOfRangeException.class)
  public void throwsOnNegativeNumber() {
    new Bearing(-1)
  }

  @Test(expected = BearingOutOfRangeException.class)
  public void throwsWhenBearingTooLarge() {
    new Bearing(Bearing.MAX + 1)
  }

  @Test
  public void answersValidBearing() {
    assert new Bearing(Bearing.MAX).value() == Bearing.MAX
  }

  @Test
  public void answersAngleBetweenItAndAnotherBearing() {
    assert new Bearing(15).angleBetween(new Bearing(12)) == 3
  }

  @Test
  public void angleBetweenIsNegativeWhenThisBearingSmaller() {
    assert new Bearing(12).angleBetween(new Bearing(15)) == -3
  }

  class BearingOutOfRangeException extends Exception {
    BearingOutOfRangeException() {
      super()
    }
  }

  class Bearing {
    static int MAX = 100
    int value

    Bearing(int num) {
      this.value = num
      if (num < 0) throw new BearingOutOfRangeException()
      if (num > Bearing.MAX) throw new BearingOutOfRangeException()
    }

    def angleBetween(Bearing bearing) {
      return this.value - bearing.value
    }

    int value() {
      return value
    }

  }
}
