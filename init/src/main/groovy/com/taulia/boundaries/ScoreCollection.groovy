package com.taulia.boundaries

/**
 * Created by brent.fisher on 9/12/16.
 */
class ScoreCollection {
  private List<Scoreable> scores = new ArrayList<Scoreable>()

  void add(Scoreable scoreable) {
    scores.add(scoreable)
  }

  public int arithmeticMean() {
    int total = scores.stream().mapToInt { Scoreable e -> e.getScore() }.sum()
    return total / scores.size()
  }
}
