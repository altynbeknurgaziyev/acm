package ru.acmp.menchikov.train04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

    private void print(int[] a, int len) {
        out.print(a[0]);
        for (int i = 1; i < len; i++) {
            out.print("+" + a[i]);
        }
        out.println();
    }

    private void rec(int[] a, int pos, int from, int sum) {
        if (sum > a.length) return;
        if (sum == a.length) {
            print(a, pos);
            return;
        }
        for (int i = from; i < a.length; i++) {
            a[pos] = i;
            rec(a, pos + 1, i, sum + i);
        }
    }

    private void solve() {
        int n = nextInt(), a[] = new int[n];
        rec(a, 0, 1, 0);
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new B().run();
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
