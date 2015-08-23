package com.enalix.algs4.test;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Created by enali on 5/8/15.
 */
public class TestStdDraw {
    public static void main(String[] args) {
        int x0 = 0;
        int x1 = 1;
        int y0 = 0;
        int y1 = 1;
        StdDraw.setXscale(x0, x1);
        StdDraw.setYscale(y0, y1);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        double midX = (y0 + y1) / 2;
        double midY = (x0 + x1) / 2;
        StdDraw.line(midX, 0, midX, midY);
    }
}
