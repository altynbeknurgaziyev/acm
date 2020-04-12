package ru.acmp.menchikov.train02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {

    private void solve() {
        int n = nextInt();
        short len = 0;

        if (n >= 100) len = 5;
        else if (n >= 10) len = 3;
        else if (n >= 4) len = 2;
        else len = 1;

        short[][] a = new short[n][n];
        short x = 0, y = 0, cnt = 0;

        while (cnt < a.length * a.length) {
            while (y < a.length && a[x][y] == 0) a[x][y++] = ++cnt;
            y--;
            x++;

            while (x < a.length && a[x][y] == 0) a[x++][y] = ++cnt;
            x--;
            y--;

            while (y >= 0 && a[x][y] == 0) a[x][y--] = ++cnt;
            y++;
            x--;

            while (x >= 0 && a[x][y] == 0) a[x--][y] = ++cnt;
            x++;
            y++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) out.print(String.format("%" + len + "s ", a[i][j]));
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
