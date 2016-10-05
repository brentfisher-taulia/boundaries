package com.taulia.boundaries

import org.joda.time.DateTime

class TimeTraveller {
  DateTime getActiveDate() {
    return activeDate
  }
  DateTime activeDate
  void openAccount(){
    DateTime now = new DateTime()
    if(isOnWeekEndOrHoliday()){
      activeDate = nextBusinessDay()
    } else {
      activeDate = now
    }
  }

}
