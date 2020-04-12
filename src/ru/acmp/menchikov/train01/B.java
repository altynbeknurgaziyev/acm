package ru.acmp.menchikov.train01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

    private boolean rec(int sum, int[] a, int s, char[] c, int index, char sign, int n) {
        c[index] = sign;

        return index + 1 == n ? sum == s : (rec(sum + a[index + 1], a, s, c, index + 1, '+', n)
                || rec(sum - a[index + 1], a, s, c, index + 1, '-', n));
    }

    private void solve() {
        int n = nextInt(), s = nextInt(), a[] = new int[n];
        char[] c = new char[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();

        if (rec(a[0], a, s, c, 0, '+', n)) {
            out.print(a[0]);
            for (int i = 1; i < n; i++) out.print("" + c[i] + a[i]);
            out.println("=" + s);
        } else out.println("No solution");
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
