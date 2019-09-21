package com.company.problem_1191;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution for 1191. K-ConcatenatiLeetCodeon Maximum Sum
 *
 * @author rashedulhasanrijul
 */
public class Main {

    private static final int MOD_VALUE = 1_000_000_007;

    public static void main(String[] args) {

        Main main = new Main();

        System.out.println(main.kConcatenationMaxSum(new int[]{1, -2, 1}, 5)); // 2
        System.out.println(main.kConcatenationMaxSum(new int[]{1, 2}, 3)); // 9
        System.out.println(main.kConcatenationMaxSum(new int[]{-1, -2}, 7)); // 0
        System.out.println(main.kConcatenationMaxSum(new int[]{-1, 2, -1}, 1)); // 2
        System.out.println(main.kConcatenationMaxSum(new int[]{1, 2, -10, 2, -1}, 10)); // 4
    }

    public int kConcatenationMaxSum(int[] arr, int k) {

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        // Calculate max sum
        long maxSum = calculateMaxSum(list);
        long maxPrefixSum = calculatePrefixSum(list);
        long maxSuffixSum = calculateSuffixSum(list);
        long totalSum = calculateTotalSum(list);

        // corner case : k = 1
        if (k == 1) {
            return (int) (maxSum % MOD_VALUE);
        }

        long res = Long.max(maxSum, maxPrefixSum + maxSuffixSum);
        res = Long.max(res, maxPrefixSum + maxSuffixSum + totalSum * (long) (k - 2));

        return (int) (res % MOD_VALUE);
    }

    private long calculateTotalSum(List<Integer> list) {
        return list.stream().reduce((a, b) -> a + b).get();
    }

    private long calculateSuffixSum(List<Integer> list) {

        Collections.reverse(list);
        long ans = calculatePrefixSum(list);
        Collections.reverse(list);
        return ans;
    }

    private long calculatePrefixSum(List<Integer> list) {

        long ans = 0, currSum = 0;

        for (int num : list) {
            currSum += num;
            ans = Long.max(ans, currSum);
        }

        return ans;
    }

    private long calculateMaxSum(List<Integer> list) {

        long ans = 0, currSum = 0;

        for (int num : list) {
            currSum += num;
            ans = Long.max(ans, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return ans;
    }
}
