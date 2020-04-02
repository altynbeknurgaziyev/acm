package com.codeforces.round.number630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D2C {

    private void solve() {
        int t = nextInt(), cnt[][] = new int[200_001][26];
        for (int tt = 0; tt < t; tt++) {
            int n = nextInt(), k = nextInt();
            String s = next();

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < 26; j++) cnt[i][j] = 0;
            }
            for (int i = 0; i < n; i++) cnt[i % k][s.charAt(i) - 'a']++;

            int res = 0;
            for (int i = 0; i < k; i++) {
                int r = k - i - 1, sum = 0, max = 0;
                for (int j = 0; j < 26; j++) {
                    sum += cnt[i][j] + cnt[r][j];
                    max = Math.max(max, cnt[i][j] + cnt[r][j]);
                }
                res += sum - max;
            }

            out.println(res / 2);
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new D2C().run();
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
