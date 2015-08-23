package com.enalix.algs4.sort;

import com.enalix.algs4.utils.Stopwatch;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by enali on 5/10/15.
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i=h; i<N; i++)
                for (int j=i; j>=h && less(a[j], a[j-h]); j-=h)
                    exch(a, j, j-h);
            h = h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i=0; i<a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        Stopwatch sw = new Stopwatch();
        sort(a);
        double time = sw.elapsedTime();
        assert isSorted(a);
        show(a);
        StdOut.println("total spend " + time + " seconds");
    }
}
