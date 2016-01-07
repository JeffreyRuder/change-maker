import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      Integer centsNeeded = Integer.parseInt(request.queryParams("change"));

      ChangeMaker cm = new ChangeMaker();
      HashMap<String, Integer> results = cm.makeChange(centsNeeded);

      model.put("centsEntered", (Integer.toString(centsNeeded) + " Cents"));

      for (Map.Entry<String, Integer> resultsIterator : results.entrySet()) {
        String key = resultsIterator.getKey();
        String value = Integer.toString(resultsIterator.getValue());
        model.put(key, value + " " + key);
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
