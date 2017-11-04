package se.bettercode.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stage {

  List<Box> boxList = new ArrayList();

  public Stage() {
    int winningBoxNumber = RandomBoxNumber.generateRandomBoxNumber();
    IntStream.rangeClosed(1, 3).forEach(boxNumber ->
        boxList.add(Box.builder().boxNumber(boxNumber).winning(boxNumber == winningBoxNumber).build())
    );
  }


  public Box getBoxByNumber(int number) {
    return boxList.stream()
        .filter(box -> box.getBoxNumber() == number)
        .findFirst()
        .get();
  }

  public void contestantSelectsBox(int number) {
    resetAllBoxesToNotSelectedByContestant();
    getBoxByNumber(number).setSelectedByContestant(true);
  }

  private void resetAllBoxesToNotSelectedByContestant() {
    boxList.forEach(box -> box.setSelectedByContestant(false));
  }

  public List<Box> getBoxList() {
    return boxList;
  }

  /**
   * Open a random one of the two boxes which was not chosen by the contestant.
   * If one of those boxes is the winning box, open the other one.
   */
  public void hostOpensABox() {
    List<Box> possibleBoxes = boxList.stream()
        .filter(box -> !box.isSelectedByContestant())
        .filter(box -> !box.isWinning())
        .collect(Collectors.toList());

    if (possibleBoxes.size() == 1) {
      possibleBoxes.get(0).setOpenedByHost(true);
    } else {
      int boxToOpen = new Random().nextInt(1) + 1;
      possibleBoxes.get(boxToOpen).setOpenedByHost(true);
    }

  }

  public void contestantChangesSelectedBox() {
    final Box boxToSelect = boxList.stream()
        .filter(box -> !box.isOpenedByHost())
        .filter(box -> !box.isSelectedByContestant())
        .findFirst()
        .get();
    resetAllBoxesToNotSelectedByContestant();
    boxToSelect.setSelectedByContestant(true);
  }

  public boolean hostOpensWinningBox() {
    final Box winningBox = boxList.stream()
        .filter(box -> box.isWinning())
        .findFirst()
        .get();
    winningBox.setOpenedByHost(true);
    return winningBox.isSelectedByContestant();
  }
}
