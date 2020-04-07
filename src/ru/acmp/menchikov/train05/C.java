package ru.acmp.menchikov.train05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

    private boolean canMove(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private void solve() {
        int n = nextInt(), K = nextInt(), a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) a[i][j] = nextInt();
        }
        int max = 0, d[][] = new int[n][n], s[][] = new int[n][n], p[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        d[0][0] = a[0][0];
        s[0][0] = 1;
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (s[i][j] != k) continue;
                    for (int pi = 0; pi < p.length; pi++) {
                        int x = i + p[pi][0];
                        int y = j + p[pi][1];
                        if (canMove(x, y, n) && d[x][y] < d[i][j] + a[x][y]) {
                            d[x][y] = d[i][j] + a[x][y];
                            s[x][y] = s[i][j] + 1;
                        }
                    }
                    if (s[i][j] == K) max = Math.max(max, d[i][j]);
                }
            }
        }
        out.println(max);
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
