package ru.acmp.menchikov.train02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

    private void solve() {
        long[] primes = new long[1_001];
        int len = 0;
        for (long i = 2; i * i <= 1_000_000; i++) {
            boolean isPrime = true;
            for (int j = 0; j < len && primes[j] * primes[j] <= i; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[len++] = i;
            }
        }

        boolean isAbsent = true;
        int m = nextInt(), n = nextInt();
        for (long i = m; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 0; j < len && primes[j] * primes[j] <= i; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                isAbsent = false;
                out.println(i);
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
