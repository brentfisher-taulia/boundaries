package com.taulia.boundaries

import org.joda.time.DateTime
import org.junit.Assert
import org.junit.Test


class TimeTravellerTest {
  @Test
  void testOpenAccountOnValidBusinessDay(){
    TimeClock timeClock = new TimeClock(new DateTime(2016,9,6,6,0))  // day after labor day
    TimeTraveller timeTraveller = new TimeTraveller()
    timeTraveller.clock = timeClock
    timeTraveller.openAccount()
    assertSameDay(timeClock.now,timeTraveller.activeDate)
  }

  public void assertSameDay(DateTime expected,DateTime actual) {
    assert expected.getDayOfMonth() == actual.getDayOfMonth()
    assert expected.getMonthOfYear() == actual.getMonthOfYear()
    assert expected.getYear() == actual.getYear()
  }

  @Test
  void testOpenAccountOnWeekend(){
    TimeClock weekend = new TimeClock(new DateTime(2016,10,16,6,0))  // weekend
    TimeClock expected = new TimeClock(new DateTime(2016,10,17,6,0))  // following monday
    TimeTraveller timeTraveller = new TimeTraveller()
    timeTraveller.clock = weekend
    timeTraveller.openAccount()
    assertSameDay(expected.now,timeTraveller.activeDate)


  }

  @Test
  void testOpenAccountOnHoliday(){
    TimeClock timeClock = new TimeClock(new DateTime(2016,9,5,6,0))  // labor day 6:00 am
    TimeClock expectedResultDayAfterLaborDay = new TimeClock(new DateTime(2016,9,6,6,0))  // day after labor day

    TimeTraveller timeTraveller = new TimeTraveller()
    timeTraveller.clock = timeClock
    timeTraveller.openAccount()
    assertSameDay(expectedResultDayAfterLaborDay.now,timeTraveller.activeDate)
  }
  @Test
  void testIsOnHoliday(){
    assert TimeTraveller.isHoliday(new DateTime(2016,9,5,6,0))
    assert TimeTraveller.isHoliday(new DateTime(2016,12,25,6,0))
  }
  @Test
  void testIsOnWeekEnd(){
    assert TimeTraveller.isOnWeekEnd(new DateTime(2016,10,16,6,0))//sunday
    assert TimeTraveller.isOnWeekEnd(new DateTime(2016,10,15,6,0))//saturday
    assert false ==TimeTraveller.isOnWeekEnd(new DateTime(2016,10,14,6,0))//friday
    assert false ==TimeTraveller.isOnWeekEnd(new DateTime(2016,10,13,6,0))//thursday

  }
  @Test
  void testNextBusinessDay(){
    TimeClock laborDay = new TimeClock(new DateTime(2016,9,5,6,0))  // labor day 6:00 am
    TimeClock expectedResultDayAfterLaborDay = new TimeClock(new DateTime(2016,9,6,6,0))  // day after labor day
    assertSameDay(expectedResultDayAfterLaborDay.now,TimeTraveller.nextBusinessDay(laborDay.now))
  }
}
