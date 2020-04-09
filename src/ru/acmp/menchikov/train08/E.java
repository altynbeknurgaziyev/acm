package ru.acmp.menchikov.train08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class E {

    static class Pair {
        int x, y, from;

        Pair(int x, int y, int from) {
            this.x = x;
            this.y = y;
            this.from = from;
        }
    }

    private void solve() {
        int n = nextInt(), index = 0;

        char[][] a = new char[n][n];
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
            for (int j = 0; j < n; j++) {
                if (a[i][j] == '@' && list.size() == 0) {
                    list.add(new Pair(i, j, -1));
                    a[i][j] = '+';
                }
            }
        }

        int[][] d = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
        boolean can = false;
        while (index < list.size() && !can) {
            for (int i = 0; i < d.length; i++) {
                int x = list.get(index).x + d[i][0];
                int y = list.get(index).y + d[i][1];
                if (0 <= x && x < n && 0 <= y && y < n) {
                    if (a[x][y] == '.') {
                        list.add(new Pair(x, y, index));
                        a[x][y] = '+';
                    }
                    if (a[x][y] == '@') {
                        can = true;
                        break;
                    }
                }
            }
            if (!can) index++;
        }
        if (!can) out.println("Impossible");
        else {
            while (index != -1) {
                a[list.get(index).x][list.get(index).y] = '@';
                index = list.get(index).from;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) out.print(a[i][j] == '+' ? '.' : a[i][j]);
                out.println();
            }
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
