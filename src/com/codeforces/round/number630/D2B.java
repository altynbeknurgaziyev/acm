package com.codeforces.round.number630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2B {

    private final long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    private void solve() {
        int t = nextInt();
        int[] c = new int[11], res = new int[1_001];
        for (int tt = 0; tt < t; tt++) {
            int n = nextInt(), color = 0;
            Arrays.fill(c, 0);
            for (int i = 0; i < n; i++) {
                int a = nextInt();
                for (int j = 0; j < primes.length; j++) {
                    if (a % primes[j] == 0) {
                        if (c[j] == 0) c[j] = ++color;
                        res[i] = c[j];
                        break;
                    }
                }
            }
            out.println(color);
            for (int i = 0; i < n; i++) out.print(res[i] + " ");
            out.println();
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new D2B().run();
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
