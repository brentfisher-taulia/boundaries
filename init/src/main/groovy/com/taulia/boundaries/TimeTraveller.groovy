package com.taulia.boundaries

class TimeTraveller {
  Date getActiveDate() {
    return activeDate
  }
  Date activeDate
  void openAccount(){
    Date now = new Date()
    if(isOnWeekEndOrHoliday()){
      activeDate = nextBusinessDay()
    } else {
      activeDate = now
    }
  }

}
