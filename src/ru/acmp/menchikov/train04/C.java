package ru.acmp.menchikov.train04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    class Gang implements Comparable<Gang> {
        int t, p, s, v;

        Gang(int t, int p, int s) {
            this.t = t;
            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(Gang g) {
            return this.t - g.t;
        }
    }

    private void solve() {
        int n = nextInt(), K = nextInt(), T = nextInt();
        int[] t = new int[n], p = new int[n], s = new int[n];
        for (int i = 0; i < n; i++) t[i] = nextInt();
        for (int i = 0; i < n; i++) p[i] = nextInt();
        for (int i = 0; i < n; i++) s[i] = nextInt();

        Gang[] g = new Gang[n + 1];
        g[0] = new Gang(0, 0, 0);
        for (int i = 0; i < n; i++) g[i + 1] = new Gang(t[i], p[i], s[i]);
        Arrays.sort(g);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (g[i].t > T) continue;
            if (g[i].s > K) continue;
            for (int j = 0; j < i; j++) {
                if (g[j].v == 0 && j > 0) continue;
                int times = g[i].t - g[j].t;
                int level = Math.abs(g[i].s - g[j].s);
                if (times >= level) {
                    if (j == 0) g[i].v = g[i].p;
                    else g[i].v = Math.max(g[i].v, g[j].v + g[i].p);
                }
            }
            max = Math.max(g[i].v, max);
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
