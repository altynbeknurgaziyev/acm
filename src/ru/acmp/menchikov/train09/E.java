package ru.acmp.menchikov.train09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {

    private void solve() {
        int n = nextInt();
        int[][] a = new int[n][n], d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] s = new int[n][n], next = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt();
                if (a[i][j] > 0) s[i][j] = i * n + j + 1;
            }
        }

        for (int step = 1; step <= n; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (s[i][j] != 0) next[i][j] = s[i][j];
                    else {
                        for (int k = 0; k < d.length; k++) {
                            int x = i + d[k][0], y = j + d[k][1];
                            if (0 <= x && x < n && 0 <= y && y < n && s[x][y] != 0) {
                                if (next[i][j] == 0) next[i][j] = s[x][y];
                                else if (next[i][j] != s[x][y]) next[i][j] = -1;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) s[i][j] = next[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j] == -1) out.print("0 ");
                else {
                    int x = (s[i][j] - 1) / n, y = (s[i][j] - 1) % n;
                    out.print(a[x][y] + " ");
                }
            }
            out.println();
        }
    }

    private void printArray(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) out.print(a[i][j] + " ");
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
        new E().run();
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
