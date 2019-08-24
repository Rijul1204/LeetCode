package com.company.pattern_132_456;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.find132pattern(new int[]{3, 1, 4, 2}));
    }

    public boolean find132pattern(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        NavigableSet<Integer> treeSet = new TreeSet<>();
        int[] smallestSoFar = new int[nums.length];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            smallestSoFar[i] = min;
            min = Integer.min(min, nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            Integer lower = treeSet.lower(nums[i]);
            if (lower != null) {
                if (lower > smallestSoFar[i]) {
                    return true;
                }
            }
            treeSet.add(nums[i]);
        }

        return false;
    }
}
