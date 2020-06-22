package ru.acmp.menchikov.train05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class E {

    private int convert(char c) {
        if ('0' <= c && c <= '9') return c - '0';
        return c - 'A' + 10;
    }

    private char convert(int n) {
        if (0 <= n && n <= 9) return (char) ('0' + n);
        return (char) ((n - 10) + 'A');
    }

    private void solve() {
        BigInteger i = new BigInteger(next()), j = new BigInteger(next()), big = BigInteger.ZERO;
        String s = next();

        for (int k = 0; k < s.length(); k++) {
            big = big.multiply(i).add(BigInteger.valueOf(convert(s.charAt(k))));
        }

        StringBuilder result = new StringBuilder("");
        while (big.compareTo(BigInteger.ZERO) != 0) {
            result.insert(0, convert(big.mod(j).intValue()));
            big = big.divide(j);
        }

        out.println(result.length() == 0 ? "0" : result.toString());
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