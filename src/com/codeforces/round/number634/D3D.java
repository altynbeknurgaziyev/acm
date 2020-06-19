package com.codeforces.round.number634;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D3D {

    private void solve() {
        int t = nextInt(), a[][] = new int[9][9];
        for (int tt = 0; tt < t; tt++) {
            for (int i = 0; i < 9; i++) {
                char[] s = next().toCharArray();
                for (int j = 0; j < 9; j++) a[i][j] = s[j] - '0';
            }
            for (int i = 0, k = 0; i < 9; i++) {
                int j = (k * 3) % 9 + i / 3;
                a[i][j] = a[i][(j + 1) % 9];
                k++;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) out.print(a[i][j]);
                out.println();
            }
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new D3D().run();
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
