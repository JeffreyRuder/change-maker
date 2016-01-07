import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  ChangeMaker changeMaker;

  @Before
  public void setUp() {
    changeMaker = new ChangeMaker();
  }


  @Test
  public void changeMaker_passInAQuarterReturnQuarter1_Quarter1() {
    assertEquals((Integer)1, (Integer)changeMaker.makeChange(25).get("Quarters"));
  }

  @Test
  public void changeMaker_passInADimeReturnDime1_Dime1() {
    assertEquals((Integer)1, (Integer)changeMaker.makeChange(10).get("Dimes"));
  }

  @Test
  public void changeMaker_passInANickelReturnNickel1_Nickel1() {
    assertEquals((Integer)1, (Integer)changeMaker.makeChange(5).get("Nickels"));
  }

  @Test
  public void changeMaker_passInFourCentsReturnPennies4_Pennies4() {
    assertEquals((Integer)4, (Integer)changeMaker.makeChange(4).get("Pennies"));
  }

  @Test
  public void changeMaker_passIn79CentsReturnPennies4_Pennies4() {
    assertEquals((Integer)4, (Integer)changeMaker.makeChange(79).get("Pennies"));
  }

  @Test
  public void changeMaker_passIn79CentsReturnQuarters3_Quarters3() {
    assertEquals((Integer)3, (Integer)changeMaker.makeChange(79).get("Quarters"));
  }

}
