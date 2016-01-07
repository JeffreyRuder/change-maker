import org.junit.*;
import static org.junit.Assert.*;

public class ChangeMachineTest {

  ChangeMachine changeMachine;

  @Before
  public void setUp() {
    changeMachine = new ChangeMachine();
  }

  @Test
  public void getQuarters_returnsZeroWhenInitialized_0() {
    assertEquals((Integer)0, changeMachine.getQuarters());
  }
}
