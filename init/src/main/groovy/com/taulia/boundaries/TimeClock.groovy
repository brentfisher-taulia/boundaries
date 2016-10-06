package com.taulia.boundaries

import org.joda.time.DateTime

class TimeClock {
  DateTime now

  TimeClock(DateTime now){
    this.now = now
  }
}
