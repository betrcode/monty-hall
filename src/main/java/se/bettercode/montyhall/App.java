package se.bettercode.montyhall;

public class App {
  public static void main(String[] args) {
    final GameShowRunner gameShowRunner = new GameShowRunner();
    gameShowRunner.runGameShows(1000);
    System.out.println("Summary: Contestant wins in " + gameShowRunner.getWinPercentage() + "%");
  }
}
