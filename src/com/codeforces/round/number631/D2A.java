package com.codeforces.round.number631;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D2A {

    private void solve() {
        int t = nextInt();
        Set<Integer> set = new HashSet<>();
        for (int tt = 0; tt < t; tt++) {
            int n = nextInt(), x = nextInt();
            set.clear();
            for (int i = 0; i < n; i++) set.add(nextInt());
            int count = 0;
            while (set.contains(count + 1) || x > 0) {
                if (!set.contains(count + 1)) x--;
                count++;
            }
            out.println(count);
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
