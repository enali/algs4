package com.enalix.algs4.utils;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by enali on 5/5/15.
 */
public class DoublingRatio {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i=0; i<N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch sw = new Stopwatch();
        ThreeSum.count(a);
        return sw.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N=250; true; N+=N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
