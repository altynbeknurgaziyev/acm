package com.codeforces.gym.dynamicnumber5;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    private String FILE_NAME = "lepus";

    private void solve() {
        int n = nextInt();
        char[] s = next().toCharArray();

        int[] max = new int[n];
        boolean[] can = new boolean[n];
        can[0] = true;
        for (int i = 1; i < n; i++) {
            for (int x = 1; x <= 5; x += 2) {
                if (i - x > -1 && s[i] != 'w' && can[i - x]) {
                    max[i] = Math.max(max[i], max[i - x] + (s[i] == '"' ? 1 : 0));
                    can[i] = true;
                }
            }
        }

        out.println(can[n - 1] ? max[n - 1] : -1);
    }

    private void run() {
        try {
            if (FILE_NAME.trim().length() == 0) {
                br = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME + ".in")));
                out = new PrintWriter(new File(FILE_NAME + ".out"));
            }
            solve();
            br.close();
            out.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
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
            } catch (Exception ex) {
                throw new RuntimeException(ex);
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
