package se.bettercode.montyhall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Box {
  private int boxNumber;
  private boolean winning;
  private boolean selectedByContestant = false;
  private boolean openedByHost = false;
}
