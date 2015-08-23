package com.enalix.algs4.utils;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by enali on 5/5/15.
 */
public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i=0; i<N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch sw = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return sw.elapsedTime();
    }

    public static void main(String[] args) {
        for (int N = 250; true; N+=N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
