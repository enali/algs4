package com.enalix.algs4.utils;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by enali on 5/4/15.
 * 给定数组,查找其中任意3个数和为0的
 */
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i=0; i<N; i++)
            for (int j=i+1; j<N; j++)
                for (int k=j+1; k<N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
