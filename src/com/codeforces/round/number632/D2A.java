package com.codeforces.round.number632;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D2A {

    private void solve() {
        int t = nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = nextInt(), m = nextInt();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) out.print('B');
                out.println();
            }
            for (int j = 0; j < m - 1; j++) out.print('B');
            out.println('W');
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new D2A().run();
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
