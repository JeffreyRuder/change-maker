import java.util.HashMap;

public class ChangeMaker {

  public HashMap<String, Integer> makeChange(Integer centsNeeded) {

    HashMap<String, Integer> results = new HashMap<String, Integer>();
    Integer quartersNeeded = 0;
    Integer dimesNeeded = 0;
    Integer nickelsNeeded = 0;
    Integer penniesNeeded = 0;

    while (centsNeeded != 0) {
      if (centsNeeded >= 25) {
        centsNeeded -= 25;
        quartersNeeded += 1;
      }
      else if (centsNeeded >= 10) {
        centsNeeded -= 10;
        dimesNeeded += 1;
      }
      else if (centsNeeded >= 5) {
        centsNeeded -= 5;
        nickelsNeeded += 1;
      }
      else {
        centsNeeded -= 1;
        penniesNeeded += 1;
      }
    }

    results.put("Quarters", quartersNeeded);
    results.put("Dimes", dimesNeeded);
    results.put("Nickels", nickelsNeeded);
    results.put("Pennies", penniesNeeded);

    return results;
  }

}
