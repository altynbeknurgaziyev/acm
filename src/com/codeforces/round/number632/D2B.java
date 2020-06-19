package com.codeforces.round.number632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D2B {

    private void solve() {
        int t = nextInt(), a[] = new int[100_001], b[] = new int[100_001];
        boolean[][] flag = new boolean[100_001][2];
        for (int tt = 0; tt < t; tt++) {
            int n = nextInt();
            boolean pos = false, neg = false;
            for (int i = 0; i < n; i++) {
                flag[i][0] = pos;
                flag[i][1] = neg;
                a[i] = nextInt();
                pos = pos || a[i] > 0;
                neg = neg || a[i] < 0;
            }
            for (int i = 0; i < n; i++) {
                b[i] = nextInt() - a[i];
            }
            if (a[0] != b[0] + a[0]) {
                out.println("NO");
                continue;
            }
            boolean can = true;
            for (int i = 1; i < n; i++) {
                if (b[i] > 0 && !flag[i][0]) can = false;
                if (b[i] < 0 && !flag[i][1]) can = false;
                if (!can) break;
            }
            out.println(can ? "YES" : "NO");
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
