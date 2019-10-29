import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerNodeDataTest {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        PlayerNodeData data = new PlayerNodeData("Federer", 1, "2");
        assertEquals(data.name, "Federer", "Name must be Federer");
        assertEquals(data.seed, 1, "Seed must be 1");
    }
}