package com.codeforces.gym.dynamicnumber5;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    private String FILE_NAME = "knight";

    private void solve() {
        int n = nextInt(), m = nextInt(), a[][] = new int[n][m];
        a[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 > -1 && j - 2 > -1) a[i][j] += a[i - 1][j - 2];
                if (i - 2 > -1 && j - 1 > -1) a[i][j] += a[i - 2][j - 1];
            }
        }
        out.println(a[n - 1][m - 1]);
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
        new C().run();
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
