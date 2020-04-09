package ru.acmp.menchikov.train05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

    private int[] a = {
            220, 284,
            1184, 1210,
            2620, 2924,
            5020, 5564,
            6232, 6368,
            10744, 10856,
            12285, 14595,
            17296, 18416,
            63020, 76084,
            66928, 66992,
            67095, 71145,
            69615, 87633,
            79750, 88730,
            100485, 124155,
            122265, 139815,
            122368, 123152,
            141664, 153176,
            142310, 168730,
            171856, 176336,
            176272, 180848,
            185368, 203432,
            196724, 202444,
            280540, 365084,
            308620, 389924,
            319550, 430402,
            356408, 399592,
            437456, 455344,
            469028, 486178,
            503056, 514736,
            522405, 525915,
            600392, 669688,
            609928, 686072,
            624184, 691256,
            635624, 712216,
            643336, 652664,
            667964, 783556,
            726104, 796696,
            802725, 863835,
            879712, 901424,
            898216, 980984,
            947835, 1125765,
            998104, 1043096
    };

    private void solve() {
        int m = nextInt(), n = nextInt();
        boolean isAbsent = true;
        for (int i = 0; i < a.length; i += 2) {
            if (m <= a[i] && a[i + 1] <= n) {
                out.println(a[i] + " " + a[i + 1]);
                isAbsent = false;
            }
        }
        if (isAbsent) out.println("Absent");
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new A().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    private Integer nextInt() {
        return Integer.parseInt(next());
    }

    private Long nextLong() {
        return Long.parseLong(next());
    }

    private Double nextDouble() {
        return Double.parseDouble(next());
    }
}
