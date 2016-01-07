import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    ChangeMachine bankOfEpicodus = new ChangeMachine(30, 30, 30);

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      Integer quartersLeft = bankOfEpicodus.getQuarters();
      Integer dimesLeft = bankOfEpicodus.getDimes();
      Integer nickelsLeft = bankOfEpicodus.getNickels();
      String penniesLeft = "The Bank of Epicodus has infinite pennies!";

      model.put("quartersLeft", quartersLeft);
      model.put("dimesLeft", dimesLeft);
      model.put("nickelsLeft", nickelsLeft);
      model.put("penniesLeft", penniesLeft);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/technician-entry", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/technician-entry.vtl");

      Integer quartersLeft = bankOfEpicodus.getQuarters();
      Integer dimesLeft = bankOfEpicodus.getDimes();
      Integer nickelsLeft = bankOfEpicodus.getNickels();
      String penniesLeft = "The Bank of Epicodus has infinite pennies!";

      model.put("quartersLeft", quartersLeft);
      model.put("dimesLeft", dimesLeft);
      model.put("nickelsLeft", nickelsLeft);
      model.put("penniesLeft", penniesLeft);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/technician-display", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/technician-display.vtl");

      Integer quartersDeposited = Integer.parseInt(request.queryParams("depositqtr"));
      Integer dimesDeposited = Integer.parseInt(request.queryParams("depositdim"));
      Integer nickelsDeposited = Integer.parseInt(request.queryParams("depositnic"));

      bankOfEpicodus.addQuarters(quartersDeposited);
      bankOfEpicodus.addDimes(dimesDeposited);
      bankOfEpicodus.addNickels(nickelsDeposited);

      model.put("Quarters", quartersDeposited);
      model.put("Dimes", dimesDeposited);
      model.put("Nickels", nickelsDeposited);

      Integer quartersLeft = bankOfEpicodus.getQuarters();
      Integer dimesLeft = bankOfEpicodus.getDimes();
      Integer nickelsLeft = bankOfEpicodus.getNickels();
      String penniesLeft = "The Bank of Epicodus has infinite pennies!";

      model.put("quartersLeft", quartersLeft);
      model.put("dimesLeft", dimesLeft);
      model.put("nickelsLeft", nickelsLeft);
      model.put("penniesLeft", penniesLeft);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      Integer centsNeeded = Integer.parseInt(request.queryParams("change"));

      ChangeMaker cm = new ChangeMaker();
      HashMap<String, String> results = cm.makeChange(bankOfEpicodus, centsNeeded);

      model.put("centsEntered", (Integer.toString(centsNeeded) + " Cents"));

      for (Map.Entry<String, String> resultsIterator : results.entrySet()) {
        String key = resultsIterator.getKey();
        String value = resultsIterator.getValue();
        model.put(key, value);
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
