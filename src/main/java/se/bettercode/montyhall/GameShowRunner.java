package se.bettercode.montyhall;

import java.util.stream.IntStream;

public class GameShowRunner {

  private double winCount = 0;
  private double totalCount = 0;

  private final boolean contestantShouldChangeBox;

  public GameShowRunner(boolean contestantShouldChangeBox) {
    this.contestantShouldChangeBox = contestantShouldChangeBox;
  }


  public void runGameShows(int count) {
    IntStream.rangeClosed(1, count).forEach(this::run);
  }

  private void run(int showNumber) {
    boolean contestantWins = new GameShow(new Stage(), contestantShouldChangeBox).run();
    totalCount++;
    if (contestantWins) {
      winCount++;
    }
  }

  public double getWinPercentage() {
    return (winCount/totalCount)*100;
  }

}
