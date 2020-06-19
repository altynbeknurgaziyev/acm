package com.codeforces.round.number634;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D3C {

    private void solve() {
        int t = nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = nextInt(), max = 0;
            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int a = nextInt();

                set.add(a);

                if (!map.containsKey(a)) map.put(a, 0);
                int cnt = map.get(a) + 1;
                max = Math.max(max, cnt);
                map.put(a, cnt);
            }
            out.println(Math.max(Math.min(max - 1, set.size()), Math.min(max, set.size() - 1)));
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new D3C().run();
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
