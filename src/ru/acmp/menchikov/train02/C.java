package ru.acmp.menchikov.train02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

    private void solve() {
        int n = nextInt(), a[][] = new int[n][n];
        char[][] way = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] s = next().toCharArray();
            for (int j = 0; j < n; j++) {
                a[i][j] = s[j] - '0';
            }
        }
        for (int i = 1; i < n; i++) {
            a[i][0] += a[i - 1][0];
            way[i][0] = 'D';
        }
        for (int i = 1; i < n; i++) {
            a[0][i] += a[0][i - 1];
            way[0][i] = 'R';
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i - 1][j] > a[i][j - 1]) {
                    a[i][j] += a[i][j - 1];
                    way[i][j] = 'R';
                } else {
                    a[i][j] += a[i - 1][j];
                    way[i][j] = 'D';
                }
            }
        }
        char[][] ans = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) ans[i][j] = '-';
        }
        int x = n - 1, y = n - 1;
        while (x != 0 || y != 0) {
            ans[x][y] = '#';
            if (way[x][y] == 'D') x--;
            else y--;
        }
        ans[0][0] = '#';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) out.print(ans[i][j]);
            out.println();
        }
        out.close();
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
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
