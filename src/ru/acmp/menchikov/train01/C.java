package ru.acmp.menchikov.train01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    private void solve() {
        int n = nextInt(), a[] = new int[n], mx[] = new int[n], fm[] = new int[n], imax = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            mx[i] = 1;
            fm[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && mx[i] < mx[j] + 1) {
                    mx[i] = mx[j] + 1;
                    fm[i] = j;
                    if (mx[imax] < mx[i]) imax = i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (imax != -1) {
            res.add(a[imax]);
            imax = fm[imax];
        }
        out.println(res.size());
        for (int i = res.size() - 1; i >= 0; i--) out.print(res.get(i) + " ");
        out.println();
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new C().run();
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
