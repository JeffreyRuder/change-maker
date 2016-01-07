import org.junit.*;
import static org.junit.Assert.*;

public class ChangeMachineTest {

  ChangeMachine changeMachine;
  ChangeMachine loadedMachine;

  @Before
  public void setUp() {
    changeMachine = new ChangeMachine();
    loadedMachine = new ChangeMachine(10, 10, 10);
  }

  @Test
  public void getQuarters_returnsZeroWhenInitialized_0() {
    assertEquals((Integer)0, changeMachine.getQuarters());
  }

  @Test
  public void getNickels_returnsZeroWhenInitialized_0() {
    assertEquals((Integer)0, changeMachine.getNickels());
  }

  @Test
  public void getDimes_returnsZeroWhenInitialized_0() {
    assertEquals((Integer)0, changeMachine.getDimes());
  }

  @Test
  public void getPennies_returnsTenThousandWhenInitialized_10000() {
    assertEquals((Integer)10000, changeMachine.getPennies());
  }

  @Test
  public void getQuarters_returnsTenWhenInitialized_10() {
    assertEquals((Integer)10, loadedMachine.getQuarters());
  }

  @Test
  public void getNickels_returnsZeroWhenInitialized_10() {
    assertEquals((Integer)10, loadedMachine.getNickels());
  }

  @Test
  public void getDimes_returnsZeroWhenInitialized_10() {
    assertEquals((Integer)10, loadedMachine.getDimes());
  }

  @Test
  public void getPennies_returnsTenThousandWhenLoadedInitialized_10000() {
    assertEquals((Integer)10000, changeMachine.getPennies());
  }
}
