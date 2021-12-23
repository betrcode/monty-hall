package se.bettercode.montyhall;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;


public class StageTest {

  //Unit under test
  Stage stage;

  @Before
  public void setUp() {
    stage = new Stage();
  }

  @Test
  public void onlyOneWinnerBox() {
    final long winningBoxCount = stage.getBoxList().stream()
        .filter(Box::isWinning)
        .count();
    assertThat(winningBoxCount, is(1L));
  }

  @Test
  public void has3Boxes() {
    assertThat(stage.getBoxList().size(), is(3));
  }

  @Test
  public void getBoxByNumber() {
    assertNull(stage.getBoxByNumber(0));
    assertNotNull(stage.getBoxByNumber(1));
    assertNotNull(stage.getBoxByNumber(2));
    assertNotNull(stage.getBoxByNumber(3));
    assertNull(stage.getBoxByNumber(4));
  }
  @Test
  public void contestantSelectsBox() {
    stage.contestantSelectsBox(1);
    assertThat(stage.getBoxByNumber(1).isSelectedByContestant(), is(true));
    assertThat(stage.getBoxByNumber(2).isSelectedByContestant(), is(false));
    assertThat(stage.getBoxByNumber(2).isSelectedByContestant(), is(false));
  }

  @Test
  public void hostOpensBox() {
    stage.hostOpensABox();
    final Box openedBox = stage.getBoxList().stream()
        .filter(Box::isOpenedByHost)
        .findFirst()
        .get();
    assertThat(openedBox.isOpenedByHost(), is(true));
    assertThat(openedBox.isSelectedByContestant(), is(false));
  }

  @Test
  public void contestantChangesSelectedBox() {
    stage.contestantSelectsBox(1);
    stage.hostOpensABox();
    stage.contestantChangesSelectedBox();
    final Box selectedBox = stage.getBoxList().stream()
        .filter(Box::isSelectedByContestant)
        .findFirst()
        .get();
    assertThat(selectedBox.isSelectedByContestant(), is(true));
    assertThat(selectedBox.getBoxNumber(), not(1));
  }

}
