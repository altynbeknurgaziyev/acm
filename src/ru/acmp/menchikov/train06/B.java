package ru.acmp.menchikov.train06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

    private void solve() {
        int n = nextInt(), a[] = new int[n], sum = 0, cnt = 1;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            sum += a[i];
        }
        boolean[] d = new boolean[sum + 1];
        d[0] = true;
        for (int j = 0; j < n; j++) {
            for (int i = sum; i >= 0; i--) {
                if (i - a[j] >= 0 && !d[i] && d[i - a[j]]) {
                    d[i] = true;
                    cnt++;
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
