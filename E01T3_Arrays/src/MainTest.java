import org.junit.Assert;
import org.junit.Test;

public class MainTest {

//    @Test
//    public void testMain() throws Exception {
//        Main.main(new String[]{"args"});
//    }

//    @Test
//    public void testAskDataArray() throws Exception {
//        double[] result = Main.askDataArray();
//        Assert.assertArrayEquals(new double[]{0d, 0d, 0d},result, 2);
//    }

    @Test
    public void testShowArray() throws Exception {
        Main.showArray(new double[]{0d, 0d});
    }

    @Test
    public void testGenerateSumToRandom() throws Exception {
        Main.generateSumToRandom(new double[]{0d, 0d, 0d});
    }

    @Test
    public void testRebootArrayWInts() throws Exception {
        Main.rebootArrayWInts(new double[]{0d, 1d, 2d});
    }

    @Test
    public void testShowTableMode() throws Exception {
        Main.showTableMode(new double[]{0d, 4d});
    }

    @Test
    public void testInterchangeCells() throws Exception {
        Main.interchangeCells(new double[]{0d, 1d, 2d});
    }

    @Test
    public void testShowSimple() throws Exception {
        Main.showSimple(new double[]{0d});
    }
}

