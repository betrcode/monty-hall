package se.bettercode.montyhall;

import java.util.stream.IntStream;

public class GameShowRunner {

  private double winCount = 0;
  private double loseCount = 0;
  private double totalCount;

  public void runGameShows(int count) {
    IntStream.rangeClosed(1, count).forEach(this::run);
  }

  private void run(int showNumber) {
    boolean contestantWins = new GameShow(new Stage(), true).run();
    totalCount++;
    if (contestantWins) {
      winCount++;
    } else {
      loseCount++;
    }
  }

  public double getWinPercentage() {
    return (winCount/totalCount)*100;
  }

}
