package se.bettercode.montyhall;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameShowRunnerTest {

  @Test
  public void proofThatChangingBoxIncreasesOddsToWin() {
    int numberOfShowsToRun = 1000;
    GameShowRunner gameShowRunnerWhereContestantChangesBox = new GameShowRunner(true);
    gameShowRunnerWhereContestantChangesBox.runGameShows(numberOfShowsToRun);
    GameShowRunner gameShowRunnerWhereContestantDoesntChangeBox = new GameShowRunner(false);
    gameShowRunnerWhereContestantDoesntChangeBox.runGameShows(numberOfShowsToRun);
    assertTrue(gameShowRunnerWhereContestantChangesBox.getWinPercentage() > gameShowRunnerWhereContestantDoesntChangeBox.getWinPercentage());
  }
}
