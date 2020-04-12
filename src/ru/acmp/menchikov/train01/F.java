package ru.acmp.menchikov.train01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {

    private void solve() {
        Integer[] a = new Integer[5];
        int[] cnt = new int[14], cnt2 = new int[6];
        for (int i = 0; i < 5; i++) {
            a[i] = nextInt();
            cnt[a[i]]++;
        }
        for (int i = 1; i <= 13; i++) cnt2[cnt[i]]++;
        Arrays.sort(a);

        if (cnt2[5] == 1) out.println("Impossible");
        else if (cnt2[4] == 1) out.println("Four of a Kind");
        else if (cnt2[3] == 1 && cnt2[2] == 1) out.println("Full House");
        else if (cnt2[1] == 5 && a[4] - a[0] == 4) out.println("Straight");
        else if (cnt2[3] == 1) out.println("Three of a Kind");
        else if (cnt2[2] == 2) out.println("Two Pairs");
        else if (cnt2[2] == 1) out.println("One Pair");
        else out.println("Nothing");
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
