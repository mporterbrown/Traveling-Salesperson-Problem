/*************************************************************************
 *  DO NOT MODIFY OR SUBMIT THIS FILE.
 *
 *  Taken from Section 3.2, An Introduction to Programming (in Java)
 *  by Robert Sedgewick and Kevin Wayne
 *
 *  Compilation:  javac Point.java
 *  Execution:    java Point < input.txt
 *
 *  Immutable data type for 2D points with floating-point coordinates.
 *
 *************************************************************************/
import edu.princeton.cs.algs4.*;

public class Point { 
    private final double x;   // Cartesian
    private final double y;   // coordinates
   
    // creates and initialize a point with given (x, y)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // returns the Euclidean distance between the two points
    public double distanceTo(Point that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    // draws this point to standard drawing
    public void draw() {
        StdDraw.point(x, y);
    }

    // draws the line segment between the two points to standard drawing
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // returns a string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // reads in a TSP file and plots the points to standard drawing
    public static void main(String[] args) {
        In in = new In ("tsp1000.txt");

        // get dimensions
        int width = in.readInt();
        int height = in.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.setPenRadius(0.005);

        // read in and plot points one at at time


        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point p = new Point(x, y);
            p.draw();
        }
    }
}
