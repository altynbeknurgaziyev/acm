package ru.acmp.menchikov.train07;

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
        int n = nextInt(), index = 0, d[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        List<Pair> list = new ArrayList<>();
        char[][] a = new char[n][n];

        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') list.add(new Pair(i, j, -1));
            }
        }

        boolean can = false;
        while (index < list.size() && !can) {
            int x = list.get(index).x;
            int y = list.get(index).y;

            for (int i = 0; i < d.length; i++) {
                int xx = x + d[i][0];
                int yy = y + d[i][1];

                if (0 <= xx && xx < n && 0 <= yy && yy < n) {
                    if (a[xx][yy] == '@') {
                        can = true;
                        break;
                    }
                    if (a[xx][yy] == '.') {
                        list.add(new Pair(xx, yy, index));
                        a[xx][yy] = '#';
                    }
                }
            }
            if (!can) index++;
        }

        if (!can) out.println("N");
        else {
            out.println("Y");
            while (index != -1) {
                a[list.get(index).x][list.get(index).y] = '+';
                index = list.get(index).from;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) out.print(a[i][j] == '#' ? '.' : a[i][j]);
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
