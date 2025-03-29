/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: This class represents the plots of land defined by (x,y) coordinates, width, and depth.
 * Constructors are provided to create default, custom-sized, and copies of plots. It also checks if any plots
 * placed by the user overlap each other, or if one plot fully encompasses another.
 * Due: 03/31/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jonathan Herrera
*/

/**
 * This class represents a Plot object with coordinates, width, and depth.
 */
public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    /**
     * Creates a default Plot with width and depth of 1.
     */
    public Plot() {
        this(0, 0, 1, 1);
    }

    /**
     * Creates a Plot using the given values.
     * @param x the x coordinate of the plot
     * @param y the y coordinate of the plot
     * @param width the width coordinate of the plot
     * @param depth the depth coordinate of the plot
     */
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Creates a new plot given another plot.
     * @param otherPlot the plot to make a copy of
     */
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    /**
     * Determines if this plot overlaps another plot.
     * @param plot the plot to test against
     * @return true if plots overlap, false otherwise
     */
    public boolean overlaps(Plot plot) {
        // Check if any of the conditions for non-overlapping are true
        return !(x >= plot.x + plot.width || 
                x + width <= plot.x || 
                y >= plot.y + plot.depth || 
                y + depth <= plot.y);
    }

    /**
     * Determines if this plot encompasses another plot.
     * @param plot the plot to test against
     * @return true if this plot contains the other plot
     */
    public boolean encompasses(Plot plot) {
        return (x <= plot.x) && 
               (y <= plot.y) && 
               (x + width >= plot.x + plot.width) && 
               (y + depth >= plot.y + plot.depth);
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Returns string representation of plot.
     * @return string in format "x,y,width,depth"
     */
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}