package com.company.problem_724;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {

        long sum = Arrays.stream(nums)
                .reduce(0, (a, b) -> a + b);

        long currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == currSum + nums[i]) {
                return i;
            }
            currSum += nums[i];
            sum -= nums[i];
        }

        return -1;
    }
}
