package se.bettercode.montyhall;

import java.util.Random;

public class RandomBoxNumber {

  public static int generateRandomBoxNumber() {
    return new Random().nextInt(3) + 1;
  }
}
