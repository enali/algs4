package com.enalix.algs4.utils;

import com.enalix.algs4.sort.Insertion;
import com.enalix.algs4.sort.Selection;
import com.enalix.algs4.sort.Shell;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by enali on 5/8/15.
 */
public class SortCompare {
    /**
     * 依据参数,返回相应算法排序一个数组的时间
     * @param alg 算法名称
     * @param a 要排序的数组
     * @return 返回排序花费时间
     */
    public static double time(String alg, Double[] a) {
        Stopwatch sw = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        return sw.elapsedTime();
    }

    /**
     * 随机产生N大小的数组,计算T次试验的总时间
     * @param alg 算法名称
     * @param N 数组大小
     * @param T 重复次数
     * @return 返回总时间
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t=0; t<T; t++) {
            for (int i=0; i<N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    /**
     * java SortCompare Insertion Selection 1000 1000
     * @param args
     */
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n  %s is ", N, alg1);
        StdOut.printf("%.1f times faster than %s\n", t2/t1, alg2);
    }
}
