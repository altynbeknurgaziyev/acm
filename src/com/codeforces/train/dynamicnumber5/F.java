package com.codeforces.train.dynamicnumber5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {

    private void solve() {
        int[] pyramid = {
                1, 4, 10, 20, 35, 56, 84, 120, 165, 220, 286, 364, 455, 560, 680, 816, 969, 1140, 1330, 1540,
                1771, 2024, 2300, 2600, 2925, 3276, 3654, 4060, 4495, 4960, 5456, 5984, 6545, 7140, 7770, 8436,
                9139, 9880, 10660, 11480, 12341, 13244, 14190, 15180, 16215, 17296, 18424, 19600, 20825, 22100,
                23426, 24804, 26235, 27720, 29260, 30856, 32509, 34220, 35990, 37820, 39711, 41664, 43680, 45760,
                47905, 50116, 52394, 54740, 57155, 59640, 62196, 64824, 67525, 70300, 73150, 76076, 79079, 82160,
                85320, 88560, 91881, 95284, 98770, 102340, 105995, 109736, 113564, 117480, 121485, 125580, 129766,
                134044, 138415, 142880, 147440, 152096, 156849, 161700, 166650, 171700, 176851, 182104, 187460,
                192920, 198485, 204156, 209934, 215820, 221815, 227920, 234136, 240464, 246905, 253460, 260130,
                266916, 273819, 280840, 287980, 295240
        };

        int[] dp = new int[300_001];
        for (int i = 1; i < 300_001; i++) {
            dp[i] = i;
            for (int j = 0; j < pyramid.length && pyramid[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - pyramid[j]] + 1);
            }
        }

        int t = nextInt();
        for (int tt = 0; tt < t; tt++) {
            out.println(dp[nextInt()]);
        }
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new F().run();
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
