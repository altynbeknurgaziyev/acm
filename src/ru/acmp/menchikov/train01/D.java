package ru.acmp.menchikov.train01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

    static class Coordinate {
        long x, y;

        Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private long area(Coordinate a, Coordinate b, Coordinate c) {
        return Math.abs((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y));
    }

    private void solve() {
        Coordinate[] coordinates = new Coordinate[4];
        for (int i = 0; i < 4; i++) coordinates[i] = new Coordinate(nextLong(), nextLong());

        long area1 = area(coordinates[0], coordinates[1], coordinates[3]);
        long area2 = area(coordinates[0], coordinates[2], coordinates[3]);
        long area3 = area(coordinates[1], coordinates[2], coordinates[3]);
        long area = area(coordinates[0], coordinates[1], coordinates[2]);

        out.println(area == area1 + area2 + area3 ? "In" : "Out");
    }

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) {
        new D().run();
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
