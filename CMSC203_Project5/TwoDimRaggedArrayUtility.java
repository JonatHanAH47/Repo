/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The TwoDimRaggedArrayUtility class provides static utility methods for working with 
 * 2D ragged arrays. It handles file input and output operations to read arrays fromt text files, with
 * the option to write them back. It also offers sums of columns, sums of rows, the minimum and maximum values
 * for the rows and columns. It also works with negative/null or void numbers in the ragged arrays, making
 * sure that they are not counted and returning 0.
 * Due: 04/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Jonathan Herrera
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {
    
    public TwoDimRaggedArrayUtility() {
    }
    
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[][] temp = new String[10][10];
        int rows = 0;
        
        while (scanner.hasNextLine() && rows < 10) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                temp[rows] = line.split(" ");
                rows++;
            }
        }
        scanner.close();
        
        if (rows == 0) {
            return null;
        }
        
        double[][] data = new double[rows][];
        for (int i = 0; i < rows; i++) {
            int cols = 0;
            while (cols < temp[i].length && temp[i][cols] != null) {
                cols++;
            }
            data[i] = new double[cols];
            for (int j = 0; j < cols; j++) {
                data[i][j] = Double.parseDouble(temp[i][j]);
            }
        }
        
        return data;
    }
    
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (int j = 0; j < row.length; j++) {
                writer.print(row[j]);
                if (j < row.length - 1) {
                    writer.print(" ");
                }
            }
            writer.println();
        }
        writer.close();
    }
    
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }
    
    public static double getAverage(double[][] data) {
        int count = 0;
        double total = getTotal(data);
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }
    
    public static double getRowTotal(double[][] data, int row) {
        if (row < 0 || row >= data.length) {
            return 0;
        }
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }
    
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }
    
    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }
        double highest = data[row][0];
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }
    
    public static int getHighestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return -1;
        }
        int highestIndex = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > data[row][highestIndex]) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }
    
    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }
        double lowest = data[row][0];
        for (double value : data[row]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }
    
    public static int getLowestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return -1;
        }
        int lowestIndex = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < data[row][lowestIndex]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }
    
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] > highest) {
                highest = row[col];
            }
        }
        return highest;
    }
    
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int highestIndex = -1;
        double highest = Double.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > highest) {
                highest = data[i][col];
                highestIndex = i;
            }
        }
        return highestIndex;
    }
    
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] < lowest) {
                lowest = row[col];
            }
        }
        return lowest;
    }
    
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int lowestIndex = -1;
        double lowest = Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < lowest) {
                lowest = data[i][col];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }
    
    public static double getHighestInArray(double[][] data) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }
    
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }
}