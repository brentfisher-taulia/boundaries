package com.taulia.boundaries

import org.joda.time.DateTime
import org.junit.Assert
import org.junit.Test


class TimeTravellerTest {
  @Test
  void testOpenAccountOnValidBusinessDay(){
    TimeTraveller timeTraveller = new TimeTraveller()
    timeTraveller.openAccount()
    assert new DateTime().getDayOfMonth() == timeTraveller.activeDate.getDayOfMonth()
    assert new DateTime().getMonthOfYear() == timeTraveller.activeDate.getMonthOfYear()
    assert new DateTime().getYear() == timeTraveller.activeDate.getYear()
  }

  @Test
  void testOpenAccountOnWeekend(){
    Assert.fail("Not implemented yet")
  }

  @Test
  void testOpenAccountOnHoliday(){
    Assert.fail("Not implemented yet")

  }
}
