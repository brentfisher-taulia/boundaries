package com.taulia.boundaries

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
