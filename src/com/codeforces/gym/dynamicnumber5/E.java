package com.codeforces.gym.dynamicnumber5;

import java.io.*;
import java.util.StringTokenizer;

public class E {

    private String FILE_NAME = "";

    private void solve() {
        int n = nextInt(), a[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) a[i][j] = nextInt();
        }
        for (int i = 2; i <= n; i++) {
            a[i][1] += a[i - 1][1];
            for (int j = 2; j < i; j++) a[i][j] += Math.max(a[i - 1][j - 1], a[i - 1][j]);
            a[i][i] += a[i - 1][i - 1];
        }
        int max = a[n][1];
        for (int i = 1; i <= n; i++) max = Math.max(max, a[n][i]);
        out.println(max);
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
        new E().run();
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
