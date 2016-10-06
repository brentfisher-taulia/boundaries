package com.taulia.boundaries

import org.joda.time.DateTime
import org.joda.time.DateTimeConstants
import org.joda.time.DateTimeField

import static org.joda.time.DateTimeConstants.*

class TimeTraveller {
  TimeClock clock
  DateTime getActiveDate() {
    return activeDate
  }
  DateTime activeDate

  void openAccount(){
    DateTime now = clock.now
    activeDate = nextBusinessDay(now)
  }

  static weekdays = [MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY]
  static DateTime nextBusinessDay(DateTime dateTime) {
    DateTime result = dateTime
    while(isOnWeekEnd(result)||isHoliday(result)){
      result = dateTime.plusDays(1)
    }
    result
  }

  static boolean isOnWeekEnd(DateTime dateTime) {
    weekdays.count { int day ->
      dateTime.dayOfWeek == day
    }==0
  }
  static def holidays = [[9,5],[12,25]]
  static boolean isHoliday(DateTime dateTime) {
    holidays.count {
      dateTime.monthOfYear == it[0] &&
        dateTime.dayOfMonth == it[1]
    }>0
  }
}
