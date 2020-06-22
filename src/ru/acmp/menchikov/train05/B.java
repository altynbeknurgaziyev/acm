package ru.acmp.menchikov.train05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B {


    private void print(char[] a) {
        for (int i = 0; i < a.length; i++) out.print(a[i]);
        out.println();
    }

    private void rec(char[] a, int pos, int open, Stack<Character> stack) {
        if (a.length == pos) {
            print(a);
            return;
        }
        if (a.length / 2 < open) return;
        if (stack.size() > 0 && stack.peek() == '(') {
            stack.pop();
            a[pos] = ')';
            rec(a, pos + 1, open, stack);
            stack.push('(');
        }
        if (stack.size() > 0 && stack.peek() == '[') {
            stack.pop();
            a[pos] = ']';
            rec(a, pos + 1, open, stack);
            stack.push('[');
        }
        if (open < a.length / 2) {
            stack.push('(');
            a[pos] = '(';
            rec(a, pos + 1, open + 1, stack);
            stack.pop();
        }

        if (open < a.length / 2) {
            stack.push('[');
            a[pos] = '[';
            rec(a, pos + 1, open + 1, stack);
            stack.pop();
        }
    }

    private void solve() {
        int n = nextInt();
        char[] a = new char[n];
        Stack<Character> stack = new Stack<>();
        rec(a, 0, 0, stack);
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
