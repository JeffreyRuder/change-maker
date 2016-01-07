import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Change Maker");
  }

  @Test
  public void resultsTest_Quarter_3() {
    goTo("http://localhost:4567/");
    fill("#change").with("89");
    submit(".btn");
    assertThat(pageSource()).contains("3 Quarters");
  }

  @Test
  public void resultsTest_Dime_1() {
    goTo("http://localhost:4567/");
    fill("#change").with("89");
    submit(".btn");
    assertThat(pageSource()).contains("1 Dimes");
  }

  @Test
  public void resultsTest_Nickel_0() {
    goTo("http://localhost:4567/");
    fill("#change").with("89");
    submit(".btn");
    assertThat(pageSource()).contains("0 Nickels");
  }

  @Test
  public void resultsTest_Penny_4() {
    goTo("http://localhost:4567/");
    fill("#change").with("89");
    submit(".btn");
    assertThat(pageSource()).contains("4 Pennies");
  }

  @Test
  public void tryAgain_index() {
    goTo("http://localhost:4567/results?change=89");
    click(".btn-success");
    assertThat(pageSource()).contains("Change Maker");
  }
}
