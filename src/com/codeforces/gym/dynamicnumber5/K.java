package com.codeforces.gym.dynamicnumber5;

import java.io.*;
import java.util.StringTokenizer;

public class K {

    private void solve() {
        int n = nextInt(), k = nextInt(), ans = 0;
        for (int i = 1; i <= n; i++) ans = (ans + k) % i;
        out.println(ans + 1);
    }

    private void run() {
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("joseph.in")));
            out = new PrintWriter(new File("joseph.out"));
            solve();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new K().run();
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
