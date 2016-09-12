package com.taulia.boundaries

import org.junit.Test

/**
 * Created by brent.fisher on 9/12/16.
 */
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
    assert 5 == sc.arithmeticMean()
  }
}
