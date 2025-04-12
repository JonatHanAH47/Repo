/**
 * Test class for TwoDimRaggedArrayUtility
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] dataSet1 = {
        {1.0, 2.0, 3.0},
        {4.0, 5.0},
        {6.0, 7.0, 8.0, 9.0}
    };
    
    private File tempFile;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        tempFile = new File("tempTestFile.txt");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    public void testReadFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(tempFile);
        writer.println("1.0 2.0 3.0");
        writer.println("4.0 5.0");
        writer.println("6.0 7.0 8.0 9.0");
        writer.close();
        
        double[][] result = TwoDimRaggedArrayUtility.readFile(tempFile);
        assertEquals(3, result.length);
        assertArrayEquals(dataSet1[0], result[0], 0.001);
        assertArrayEquals(dataSet1[1], result[1], 0.001);
        assertArrayEquals(dataSet1[2], result[2], 0.001);
    }

    @Test
    public void testWriteToFile() throws FileNotFoundException {
        TwoDimRaggedArrayUtility.writeToFile(dataSet1, tempFile);
        double[][] result = TwoDimRaggedArrayUtility.readFile(tempFile);
        assertArrayEquals(dataSet1, result);
    }

    @Test
    public void testGetTotal() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(5.0, TwoDimRaggedArrayUtility.getAverage(dataSet1), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), 0.001);
        assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), 0.001);
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 3), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), 0.001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), 0.001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), 0.001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1), 0.001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 3), 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 3));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), 0.001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 3), 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 3));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), 0.001);
    }
}