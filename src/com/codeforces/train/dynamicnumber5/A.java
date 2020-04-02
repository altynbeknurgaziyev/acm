package com.codeforces.train.dynamicnumber5;

import java.io.*;
import java.util.StringTokenizer;

public class A {

    private String FILE_NAME = "ladder";

    private void solve() {
        int n = nextInt(), a[] = new int[n + 2];
        for (int i = 0; i < n; i++) a[i + 2] = nextInt();
        for (int i = 1; i < n; i++) a[i + 2] += Math.max(a[i + 1], a[i]);
        out.println(a[n + 1]);
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
        new A().run();
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
