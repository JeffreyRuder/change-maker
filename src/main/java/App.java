import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    ChangeMachine bankOfEpicodus = new ChangeMachine(100, 100, 100);

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
