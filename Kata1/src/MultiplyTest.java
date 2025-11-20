import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MultiplyTest {
    @Test
    public void testMultiply1() {
        assertEquals(6, Multiply.multiply(2, 3));
    }
    @Test
    public void testMultiply2() {
        assertEquals(0, Multiply.multiply(0, 100));
    }
    @Test
    public void testMultiply3() {
        assertEquals(-15, Multiply.multiply(-5, 3));
    }
    @Test
    public void testMultiply4() {
        assertEquals(15, Multiply.multiply(-5, -3));
    }
}
