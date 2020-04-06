package com.codeforces.gym.dynamicnumber5;

import java.io.*;
import java.util.StringTokenizer;

public class D {

    private String FILE_NAME = "king2";

    private void solve() {
        int n = 8;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) a[i][j] = nextInt();
        }
        for (int i = n - 2; i >= 0; i--) a[i][0] += a[i + 1][0];
        for (int i = 1; i < n; i++) a[n - 1][i] += a[n - 1][i - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                a[i][j] += Math.min(Math.min(a[i + 1][j], a[i][j - 1]), a[i + 1][j - 1]);
            }
        }
        out.println(a[0][n - 1]);
    }

    private void run() {
        try {
            if (FILE_NAME.trim().length() == 0) {
                br = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME + ".in")));
                out = new PrintWriter(new File(FILE_NAME + ".out"));
            }
            solve();
            br.close();
            out.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        new D().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
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
