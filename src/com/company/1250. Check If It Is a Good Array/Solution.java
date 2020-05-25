class Solution {
    
    int gcd (int a, int b) {
        if (a ==0) return b;
        if (b ==0) return a;
        return gcd(b%a, a);
    }
    public boolean isGoodArray(int[] nums) {
        
        if (nums.length == 0) return false;
        int gcdValue = nums[0];
        
        for (int num: nums) {
            gcdValue = gcd(gcdValue, num);
        }
        
        return (gcdValue == 1);
    }
}
