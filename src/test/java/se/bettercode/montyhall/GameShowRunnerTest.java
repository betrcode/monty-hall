package se.bettercode.montyhall;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameShowRunnerTest {

  @Test
  public void proofThatChangingBoxIncreasesOddsToWin() {
    GameShowRunner gameShowRunner = new GameShowRunner();
    gameShowRunner.runGameShows(1000);
    assertTrue(gameShowRunner.getWinPercentage() > 60);
  }
}
