package ru.acmp.menchikov.train03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {

    private int len(int n) {
        int cnt = 0;
        while (n > 0) {
            n /= 10;
            cnt++;
        }
        return cnt;
    }

    private void solve() {
        int n = nextInt();
        String format = "%" + len(n * n) + "d";

        int x = 0, y = 0, d = 0, f[][] = new int[n][n];
        for (int cnt = 1; cnt <= n * n; cnt++) {
            f[x][y] = cnt;
            if (d == 0) {
                if (y == n - 1) {
                    x += 1;
                    d = 1;
                } else if (x == 0) {
                    y += 1;
                    d = 1;
                } else {
                    x--;
                    y++;
                }
            } else {
                if (x == n - 1) {
                    y += 1;
                    d = 0;
                } else if (y == 0) {
                    x += 1;
                    d = 0;
                } else {
                    x++;
                    y--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(String.format(format, f[i][j]) + " ");
            System.out.println();
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new F().run();
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