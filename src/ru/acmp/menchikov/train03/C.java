package ru.acmp.menchikov.train03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

    private void solve() {
        int e = nextInt(), f = nextInt(), n = nextInt(), p[] = new int[n], w[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = nextInt();
            w[i] = nextInt();
        }
        int[][] dp = new int[f - e + 1][2];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0 || dp[i][0] > 0) {
                for (int j = 0; j < n; j++) {
                    if (i + w[j] < dp.length) {
                        dp[i + w[j]][0] = Math.max(dp[i + w[j]][0], dp[i][0] + p[j]);
                        if (dp[i + w[j]][1] == 0) dp[i + w[j]][1] = dp[i][1] + p[j];
                        else dp[i + w[j]][1] = Math.min(dp[i + w[j]][1], dp[i][1] + p[j]);
                    }
                }
            }
        }
        if (dp[dp.length - 1][0] == 0) {
            out.println("This is impossible.");
        } else {
            out.println(dp[dp.length - 1][1] + " " + dp[dp.length - 1][0]);
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new C().run();
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
