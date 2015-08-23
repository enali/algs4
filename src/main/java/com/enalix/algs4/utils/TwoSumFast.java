package com.enalix.algs4.utils;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

/**
 * Created by enali on 5/5/15.
 */
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i=0; i<N; i++)
            if (BinarySearch.rank(-a[i], a) > i)
                cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
