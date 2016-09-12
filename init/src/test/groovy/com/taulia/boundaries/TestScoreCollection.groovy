package com.taulia.boundaries

import org.junit.Test

class TestScoreCollection {
  @Test
  void testSum() {
    ScoreCollection sc = new ScoreCollection()
    1..5.each {
      sc.add(new Scoreable() {
        @Override
        int getScore() {
          it * 5
        }
      })
    }
    assert 25 == sc.arithmeticMean()
  }
}
