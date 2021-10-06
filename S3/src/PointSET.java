/****************************************************************************
 *  Compilation:  javac PointSET.java
 *  Execution:
 *  Dependencies:
 *  Author:
 *  Date:
 *
 *  Data structure for maintaining a set of 2-D points,
 *    including rectangle and nearest-neighbor queries
 *
 *************************************************************************/

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;


public class PointSET {

    private SET<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        points = new SET<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        points.add(p);
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return points.contains(p);
    }

    // draw all of the points to standard draw
    public void draw() {
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        ArrayList<Point2D> iter = new ArrayList<>(points.size());
        for (Point2D key : points) {
            if (key.x() >= rect.xmin() && key.x() <= rect.xmax()) {
                if (key.y() >= rect.ymin() && key.y() <= rect.ymax()) {
                    iter.add(key);

                }
            }
        }
        return iter;

    }
    

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        if (!isEmpty()) {
            //keep track of the nearest point and the distance
            Point2D near = new Point2D(0.0, 0.0);
            double min = 1.0;
            for (Point2D key : points) {
                double distance = key.distanceTo(p);
                //if the distance is smaller then the current min then we override the current point with the new one
                if (distance < min) {
                    min = distance;
                    near = key;
                }
            }
            return near;
        }
        return null;
    }

    public static void main(String[] args) {
        PointSET test = new PointSET();
        Point2D p = new Point2D(0.2, 0.5);
        Point2D r = new Point2D(0.3, 0.5);
        Point2D t = new Point2D(0.1, 0.2);
        Point2D x = new Point2D(0.5, 0.8);
        Point2D q = new Point2D(0.3, 0.4);
        test.insert(p);
        test.insert(r);
        test.insert(t);
        test.insert(x);
        StdOut.println(test.contains(p));
        StdOut.println(test.contains(r));
        RectHV some = new RectHV(0.1, 0.4, 0.6, 0.8);
        StdOut.println(test.range(some));
        StdOut.println(test.nearest(q));

    }

}
