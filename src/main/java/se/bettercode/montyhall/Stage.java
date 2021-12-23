package se.bettercode.montyhall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class Stage {

  private static final int NUMBER_OF_BOXES = 3;

  private final Map<Integer, Box> boxes = new HashMap<>();

  public Stage() {
    int winningBoxNumber = RandomBoxNumber.generateRandomBoxNumber();
    IntStream.rangeClosed(1, NUMBER_OF_BOXES).forEach(boxNumber -> {
        Box box = Box.builder()
              .boxNumber(boxNumber)
              .winning(boxNumber == winningBoxNumber)
              .build();
        boxes.put(boxNumber, box);
      }
    );
  }

  public Box getBoxByNumber(int number) {
    return boxes.get(number);
  }

  public void contestantSelectsBox(int number) {
    resetAllBoxesToNotSelectedByContestant();
    getBoxByNumber(number).setSelectedByContestant(true);
  }

  private void resetAllBoxesToNotSelectedByContestant() {
    boxes.values().forEach(box -> box.setSelectedByContestant(false));
  }

  public List<Box> getBoxList() {
    return boxes.values().stream().toList();
  }

  /**
   * Open a random one of the two boxes which was not chosen by the contestant.
   * If one of those boxes is the winning box, open the other one.
   */
  public void hostOpensABox() {
    List<Box> possibleBoxes = boxes.values().stream()
            .filter(box -> !box.isSelectedByContestant())
            .filter(box -> !box.isWinning())
            .toList();

    if (possibleBoxes.size() == 1) {
      possibleBoxes.get(0).setOpenedByHost(true);
    } else {
      int boxToOpen = new Random().nextInt(1) + 1;
      possibleBoxes.get(boxToOpen).setOpenedByHost(true);
    }

  }

  public void contestantChangesSelectedBox() {
    final Box boxToSelect = boxes.values().stream()
        .filter(box -> !box.isOpenedByHost())
        .filter(box -> !box.isSelectedByContestant())
        .findFirst()
        .orElseThrow();
    resetAllBoxesToNotSelectedByContestant();
    boxToSelect.setSelectedByContestant(true);
  }

  public boolean hostOpensWinningBox() {
    final Box winningBox = boxes.values().stream()
        .filter(Box::isWinning)
        .findFirst()
        .orElseThrow();
    winningBox.setOpenedByHost(true);
    return winningBox.isSelectedByContestant();
  }
}
