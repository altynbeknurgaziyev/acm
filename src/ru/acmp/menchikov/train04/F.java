package ru.acmp.menchikov.train04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class F {

    private void solve() {
        int n = nextInt();
        char[] s = next().toCharArray();

        Stack<Character> stack = new Stack<>();
        boolean correct = true;

        for (int i = 0; i < n && correct; i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') stack.push(s[i]);
            else {
                if (s[i] == ')' && (stack.isEmpty() || stack.pop() != '(')) correct = false;
                if (s[i] == '}' && (stack.isEmpty() || stack.pop() != '{')) correct = false;
                if (s[i] == ']' && (stack.isEmpty() || stack.pop() != '[')) correct = false;
            }
        }

        out.println(correct && stack.isEmpty() ? "Yes" : "No");
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
