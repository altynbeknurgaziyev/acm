package com.codeforces.round.number629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D3B {

    private void solve() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            long n = nextLong(), k = nextLong(), a = 0;
            while (a * (a + 1) / 2 < k) a++;
            long b = k - (a * (a - 1) / 2) - 1;
            for (int q = 0; q < n; q++) {
                if (n - a - 1 == q) out.print('b');
                else if (n - b - 1 == q) out.print('b');
                else out.print('a');
            }
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
        new D3B().run();
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
