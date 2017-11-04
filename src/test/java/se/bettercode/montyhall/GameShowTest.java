package se.bettercode.montyhall;

import org.junit.Test;

public class GameShowTest {

  @Test
  public void canRunGameShow() {
    GameShow gameShow = new GameShow(new Stage(), true);
    final boolean contestantWins = gameShow.run();
    //Not much to assert since the result is not deterministic unless we mock the Stage
  }

}
