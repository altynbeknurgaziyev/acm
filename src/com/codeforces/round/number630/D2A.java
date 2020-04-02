package com.codeforces.round.number630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D2A {

    private void solve() {
        int t = nextInt();
        for (int tt = 0; tt < t; tt++) {
            long a = nextLong(), b = nextLong(), c = nextLong(), d = nextLong();
            long x = nextLong() + b - a, y = nextLong() + d - c;
            long x1 = nextLong(), y1 = nextLong(), x2 = nextLong(), y2 = nextLong();

            if ((x1 == x2 && (a > 0 || b > 0)) || (y1 == y2 && (c > 0 || d > 0))) {
                out.println("no");
            } else if (x1 <= x && x <= x2 && y1 <= y && y <= y2) {
                out.println("yes");
            } else {
                out.println("no");
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
        new D2A().run();
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
