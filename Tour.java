/***  Mason Porter-Brown
 *    mp3902@bard.edu
 *    3/4/20
 *    Lab 4 Tour Class
 *    Collaboration Statement: I worked on this lab alone.
 */

import edu.princeton.cs.algs4.*;

public class Tour {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    private class Node {
        private Point p;
        private Node next;
    }

    public Tour() {

        first = null;
        last = null;
        n = 0;
    }

    void show() {
        for (Node x = first; x != null; x = x.next) {
            System.out.println(x.p);
        }


    }

    void draw() {
        for (Node x = first; x != null; x = x.next) {
            x.p.draw();
            if (x.next != null) {
                x.p.drawTo(x.next.p);
            }
        }
    }

    int size() {
        return n;
    }  // number of points on tour

    boolean isEmpty() {
        return first == null;
    }

    public double distance() {  // return the total distance of the tour

        double distance = 0;
        for (Node x = first; x.next != null; x = x.next) {
            distance += x.p.distanceTo(x.next.p);
        }
        return distance;
    }


    public void insert(Point point) { // Used for testing Point methods
        Node oldlast = last;
        last = new Node();
        last.p = point;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }
    
    void insertNearest(Point p) {

        if (isEmpty()) {
            last = new Node();
            last.p = p;
            first = last;

            //System.out.println("is empty");
        }
        double minDistance = 999999999;
        Node tempX = new Node();
        for (Node x = first; x != null; x = x.next) {
            if (x.p.distanceTo(p) < minDistance) {
                tempX = x;
                minDistance = x.p.distanceTo(p);
            }
        }
        n++;
        Node nextNode = new Node();
        nextNode.p = p;
        nextNode.next = tempX.next;
        tempX.next = nextNode;
    }

    void insertSmallest(Point p) {
        if (isEmpty()) {
            last = new Node();
            last.p = p;
            first = last;
            //System.out.println("is empty");
        }

        if (first.next == null) {
            Node temp = new Node();
            temp.p = p;
            first.next = temp;
        }

        double minDistance = 1999999999;
        Node tempX = new Node();
        for (Node x = first; x.next != null; x = x.next) {

            if ((x.p.distanceTo(p) + p.distanceTo(x.next.p)) - x.p.distanceTo(x.next.p) < minDistance) {
                tempX = x;
                minDistance = (x.p.distanceTo(p) + p.distanceTo(x.next.p)) - x.p.distanceTo(x.next.p);
            }
        }
        Node nextNode = new Node();
        nextNode.p = p;
        nextNode.next = tempX.next;
        tempX.next = nextNode;
        n++;
    }
}
