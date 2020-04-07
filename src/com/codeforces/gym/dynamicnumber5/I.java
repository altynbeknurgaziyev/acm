package com.codeforces.gym.dynamicnumber5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class I {

    private void solve() {
        int s = nextInt(), n = nextInt(), a[] = new int[n], max = 0;
        boolean[] dp = new boolean[s + 1];

        for (int i = 0; i < n; i++) a[i] = nextInt();

        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = s; j >= 0; j--) {
                if (j + a[i] <= s && dp[j]) {
                    dp[j + a[i]] = true;
                    max = Math.max(max, j + a[i]);
                }
            }
        }
        out.println(max);
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new I().run();
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
