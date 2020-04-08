package com.codeforces.gym.dynamicnumber5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G {

    private int dfs(int v, List<Integer>[] g, int[] cnt) {
        for (int i = 0; i < g[v].size(); i++) {
            int u = g[v].get(i);
            if (cnt[u] == 0 && g[u].size() > 0) {
                dfs(u, g, cnt);
            }
            cnt[v] = Math.max(cnt[v], cnt[u] + 1);
        }
        return cnt[v];
    }

    private void solve() {
        int n = nextInt(), m = nextInt();

        List<Integer>[] g = new List[n];
        boolean[] entry = new boolean[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            entry[i] = true;
        }

        for (int i = 0; i < m; i++) {
            int b = nextInt() - 1, c = nextInt() - 1;
            entry[c] = false;
            g[b].add(c);
        }

        int max = 0, cnt[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (entry[i]) max = Math.max(max, dfs(i, g, cnt));
        }
        out.println(max);
    }


    private void run() {
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("longpath.in")));
            out = new PrintWriter(new File("longpath.out"));
            solve();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new G().run();
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
