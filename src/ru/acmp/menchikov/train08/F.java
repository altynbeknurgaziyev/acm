package ru.acmp.menchikov.train08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {

    private void dfs(int x, int y, char[][] a) {
        if (x < 0 || y < 0 || x >= a.length || y >= a[0].length) return;
        if (a[x][y] != '#') return;

        a[x][y] = '+';
        dfs(x + 1, y, a);
        dfs(x - 1, y, a);
        dfs(x, y - 1, a);
        dfs(x, y + 1, a);
    }

    private void solve() {
        int n = nextInt(), m = nextInt(), cnt = 0;
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) a[i] = next().toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '#') {
                    cnt++;
                    dfs(i, j, a);
                }
            }
        }
        out.println(cnt);
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
