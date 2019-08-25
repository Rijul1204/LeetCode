package com.company.Video_Stitching;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();

        int[][] input = new int[][]{
                {0, 1},
                {1, 2}};
        System.out.println(main.videoStitching(input, 5));
    }

    private int[][] dp;
    private boolean[][] vis;

    public int videoStitching(int[][] clips, int T) {

        Arrays.sort(clips, (clip1, clip2) -> {
            return clip1[0] - clip2[0];
        });

        dp = new int[clips.length][T + 1];
        vis = new boolean[clips.length][T + 1];

        return cal(0, 0, clips, T);
    }

    private int cal(int ind, int start, int[][] clips, int len) {
        if (start > len) {
            return 0;
        }
        if (ind >= clips.length || clips[ind][0] > start) {
            return -1;
        }

        if (vis[ind][start]) {
            return dp[ind][start];
        }
        vis[ind][start] = true;

        int resWithoutTaking = cal(ind + 1, start, clips, len);
        int resWithTaking = cal(ind + 1, Integer.max(start, clips[ind][1] + 1), clips, len);

        if (resWithoutTaking == -1 && resWithTaking == -1) {
            dp[ind][start] = -1;
        } else if (resWithoutTaking == -1) {
            dp[ind][start] = resWithTaking + 1;
        } else if (resWithTaking == -1) {
            dp[ind][start] = resWithoutTaking;
        } else {
            dp[ind][start] = Integer.min(resWithTaking + 1, resWithoutTaking);
        }

        return dp[ind][start];
    }
}
