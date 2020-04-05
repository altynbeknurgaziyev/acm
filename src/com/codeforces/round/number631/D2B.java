package com.codeforces.round.number631;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D2B {

    static class Pair {
        long l, r;

        public Pair(long l, long r) {
            this.l = l;
            this.r = r;
        }
    }

    public long sum(long n) {
        return n * (n + 1) / 2;
    }

    private void solve() {
        int t = nextInt();
        long[] a = new long[200_001], sum = new long[200_001], len = new long[200_001];
        Set<Long> set = new HashSet<>();

        for (int tt = 0; tt < t; tt++) {
            int n = nextInt();

            long summ = 0;
            set.clear();
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
                set.add(a[i]);
                summ += a[i];
                sum[i] = summ;
                len[i] = set.size();
            }

            summ = 0;
            set.clear();
            List<Pair> ans = new ArrayList<>();
            for (int i = n - 1; i >= 1; i--) {
                set.add(a[i]);
                summ += a[i];

                if (sum(set.size()) == summ && sum(len[i - 1]) == sum[i - 1]) {
                    ans.add(new Pair(len[i - 1], set.size()));
                }
            }

            out.println(ans.size());
            for (int i = ans.size() - 1; i >= 0; i--) {
                out.println(ans.get(i).l + " " + ans.get(i).r);
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
        new D2B().run();
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

