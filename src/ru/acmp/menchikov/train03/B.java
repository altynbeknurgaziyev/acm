package ru.acmp.menchikov.train03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {

    private void rec(char[] s, boolean[] used, String print, Set<String> set) {
        if (print.length() == s.length) {
            if (!set.contains(print)) {
                set.add(print);
                out.println(print);
            }
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (!used[i]) {
                used[i] = true;
                rec(s, used, print + s[i], set);
                used[i] = false;
            }
        }
    }

    private void solve() {
        char[] s = next().toCharArray();
        boolean[] used = new boolean[s.length];
        Set<String> set = new HashSet<>();
        rec(s, used, "", set);
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
