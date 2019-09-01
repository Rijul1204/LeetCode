package com.company.problem_274;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    public int hIndex(int[] citations) {

        int lo = 0, hi = citations.length;
        int res = 0;

        while (lo <= hi) {

            int mid = lo + hi;
            mid /= 2;

            if (possibleHIndex(mid, citations)) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }

    private boolean possibleHIndex(int h, int[] citations) {

        int cnt = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h) {
                cnt++;
            }
        }

        return (cnt >= h);
    }
}
