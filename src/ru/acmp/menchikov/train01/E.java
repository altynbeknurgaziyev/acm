package ru.acmp.menchikov.train01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class E {

    private BigInteger binPow(BigInteger a, int n) {
        if (n == 0) return BigInteger.ONE;
        if (n % 2 == 1) return binPow(a, n - 1).multiply(a);

        BigInteger b = binPow(a, n / 2);
        return b.multiply(b);
    }

    private void solve() {
        int a = nextInt(), n = nextInt();
        out.println(binPow(BigInteger.valueOf(a), n));
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
