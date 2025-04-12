/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The HolidayBoys class calculates performance-based bonuses for each district 
 * based on the sales found in the ragged array. There are three different level of bonuses,
 * $5000 for the highest sales in a column, $1000 for the lowest, and $2000 for the rest. This is done
 * through the calculateHolidayBonus() method. Any negative numbers or null values result in a bonus of $0.
 * The calculateTotalHolidayBonus() method adds the bonuses up and gives us the total amount of bonuses 
 * received. This class relies on the  TwoDimRaggedArrayUtility class to analyze column performance.
 * Due: 04/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Jonathan Herrera
*/


public class HolidayBonus {
    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    public HolidayBonus() {
    }

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        int maxCols = 0;
        for (double[] row : data) {
            if (row.length > maxCols) {
                maxCols = row.length;
            }
        }

        for (int col = 0; col < maxCols; col++) {
            int validCount = 0;
            for (double[] row : data) {
                if (col < row.length && row[col] > 0) {
                    validCount++;
                }
            }

            if (validCount == 0) continue;

            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            if (validCount == 1) {
                if (col < data[highIndex].length && data[highIndex][col] > 0) {
                    bonuses[highIndex] += HIGHEST_BONUS;
                }
            } else {
                if (col < data[highIndex].length && data[highIndex][col] > 0) {
                    bonuses[highIndex] += HIGHEST_BONUS;
                }

                if (lowIndex != highIndex &&
                    col < data[lowIndex].length &&
                    data[lowIndex][col] > 0) {
                    bonuses[lowIndex] += LOWEST_BONUS;
                }

                for (int row = 0; row < data.length; row++) {
                    if (row != highIndex && row != lowIndex &&
                        col < data[row].length && data[row][col] > 0) {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}
