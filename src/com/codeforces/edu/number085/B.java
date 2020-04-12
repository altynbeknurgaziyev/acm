package com.codeforces.edu.number085;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

    private void solve() {
        int t = nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = nextInt();
            long x = nextLong(), sum = 0;

            Long a[] = new Long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            Arrays.sort(a);

            int cnt = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] >= x) {
                    sum += a[i] - x;
                    cnt++;
                } else if (sum >= (x - a[i])) {
                    sum -= x - a[i];
                    cnt++;
                }
            }
            out.println(cnt);
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new B().run();
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
