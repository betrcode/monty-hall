package se.bettercode.montyhall;

import static se.bettercode.montyhall.RandomBoxNumber.generateRandomBoxNumber;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameShow {

  private Stage stage;
  private boolean contestantShouldChangeBox;

  /**
   * Readable steps of the game show
   */
  public boolean run() {
    int contestantChosenBoxNumber = generateRandomBoxNumber();
    stage.contestantSelectsBox(contestantChosenBoxNumber);
    stage.hostOpensABox();
    if (contestantShouldChangeBox) {
      stage.contestantChangesSelectedBox();
    }
    boolean contestantWins = stage.hostOpensWinningBox();
    return contestantWins;
  }
}
