package com.company.continuous_subarray_sum_523;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> sumCount = new HashMap<>();

        if(k < 0) {
            k = -k;
        }

        int sum =0;
        for(int num : nums) {
            sum = getSum(sum, num, k);
            if(!sumCount.containsKey(sum)) {
                sumCount.put(sum, 0);
            }
            sumCount.put(sum, sumCount.get(sum) + 1);
        }

        int req=0;
        int rem = nums.length;
        sum =0;
        for(int num : nums){
            sum = getSum(sum, num, k);
            sumCount.put(sum, sumCount.get(sum) -1);
            if(rem<2) {
                break;
            }
            rem--;
            if(sumCount.containsKey(req) && sumCount.get(req) > 0) return true;
            req = getSum(req, num, k);
        }

        return false;
    }

    int getSum(int curr, int add, int k){
        long val = curr + add;

        if(val<0) {
            val+=k;
        }
        if(k!=0) val%=k;

        return (int)val;
    }
}
