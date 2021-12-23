package se.bettercode.montyhall;

public class App {
  public static void main(String[] args) {
    int numberOfGameShowsToRun = 1000;
    final GameShowRunner runnerWhereContestantDoesntChangeBox = new GameShowRunner(false);
    runnerWhereContestantDoesntChangeBox.runGameShows(numberOfGameShowsToRun);
    System.out.println("===============================================================");
    System.out.println("Ran game show 1000 times and contestant never changed box.");
    System.out.println("Summary: Contestant wins in " + runnerWhereContestantDoesntChangeBox.getWinPercentage() + "%");
    System.out.println("===============================================================");
    final GameShowRunner runnerWhereContestantChangesBox = new GameShowRunner(true);
    runnerWhereContestantChangesBox.runGameShows(numberOfGameShowsToRun);
    System.out.println("Ran game show 1000 times and contestant changed box every time.");
    System.out.println("Summary: Contestant wins in " + runnerWhereContestantChangesBox.getWinPercentage() + "%");
    System.out.println("===============================================================");
  }
}
