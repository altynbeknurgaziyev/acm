package ru.acmp.menchikov.train04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

    private void solve() {
        long m = nextInt(), n = nextInt();
        boolean isAbsent = true;
        for (long i = m; i <= n; i++) {
            long sum = 1;
            for (long j = 2; j * j <= i; j++) {
                if (i % j == 0) sum += j + (j * j != i ? i / j : 0);
            }
            if (sum == i && i > 1) {
                out.println(i);
                isAbsent = false;
            }
        }
        if (isAbsent) out.println("Absent");
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new A().run();
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
