import java.util.HashMap;

public class ChangeMaker {

  public HashMap<String, String> makeChange(ChangeMachine changeMachine, Integer centsNeeded) {

    HashMap<String, String> results = new HashMap<String, String>();
    Integer startingAmount = centsNeeded;
    Integer quartersNeeded = 0;
    Integer dimesNeeded = 0;
    Integer nickelsNeeded = 0;
    Integer penniesNeeded = 0;
    String qtrMsg = "The Bank of Epicodus is low on quarters, sorry.";
    String dimMsg = "The Bank of Epicodus is low on dimes, sorry.";
    String nicMsg = "The Bank of Epicodus is low on nickels, sorry.";
    String penMsg = "The Bank of Epicodus has infinite pennies, no worries!";

    while (centsNeeded != 0) {
      if (centsNeeded >= 25 && changeMachine.getQuarters() > 0) {
        centsNeeded -= 25;
        quartersNeeded += 1;
        changeMachine.subtractQuarter();
      }
      else if (centsNeeded >= 10 && changeMachine.getDimes() > 0) {
        centsNeeded -= 10;
        dimesNeeded += 1;
        changeMachine.subtractDime();
      }
      else if (centsNeeded >= 5 && changeMachine.getNickels() > 0) {
        centsNeeded -= 5;
        nickelsNeeded += 1;
        changeMachine.subtractNickel();
      }
      else {
        centsNeeded -= 1;
        penniesNeeded += 1;
      }
    }

    while (startingAmount != 0) {
      if (quartersNeeded == startingAmount / 25) {
        qtrMsg = "You received the correct number of quarters.";
      }
      startingAmount -= quartersNeeded * 25;
      if (dimesNeeded == startingAmount / 10) {
        dimMsg = "You received the correct number of dimes.";
      }
      startingAmount -= dimesNeeded * 10;
      if (nickelsNeeded == startingAmount / 5) {
        nicMsg = "You received the correct number of nickels.";
      }
      startingAmount -= nickelsNeeded * 5;
      startingAmount -= penniesNeeded;
    }

    results.put("Quarters", Integer.toString(quartersNeeded));
    results.put("Dimes", Integer.toString(dimesNeeded));
    results.put("Nickels", Integer.toString(nickelsNeeded));
    results.put("Pennies", Integer.toString(penniesNeeded));
    results.put("qtrMsg", qtrMsg);
    results.put("dimMsg", dimMsg);
    results.put("nicMsg", nicMsg);
    results.put("penMsg", penMsg);
    results.put("quartersLeft", Integer.toString(changeMachine.getQuarters()));
    results.put("dimesLeft", Integer.toString(changeMachine.getDimes()));
    results.put("nickelsLeft", Integer.toString(changeMachine.getNickels()));
    results.put("penniesLeft", "The Bank of Epicodus has infinite pennies!");

    return results;
  }

}
