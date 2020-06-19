package ru.acmp.menchikov.train05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class F {

    private int check(int day, int month, int year) {
        if (month == 2 && day == 29) {
            while (!(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) year++;
        }
        return year;
    }

    private void solve() {
        int d = nextInt(), m = nextInt();
        int D = nextInt(), M = nextInt(), Y = nextInt();
        String dateFormat = "%d-%d-%d";

        try {
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date current = format.parse(String.format(dateFormat, D, M, Y));
            Date to = format.parse(String.format(dateFormat, d, m, check(d, m, Y)));
            if (current.getTime() > to.getTime()) {
                to = format.parse(String.format(dateFormat, d, m, check(d, m, Y + 1)));
            }
            long diff = to.getTime() - current.getTime();
            System.out.println(diff / (1000L * 60L * 60L * 24L));
        } catch (ParseException e) {
            throw new RuntimeException(e);
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