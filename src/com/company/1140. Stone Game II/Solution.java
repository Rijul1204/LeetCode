class Solution {
    
    private static final int ALEX = 0;
    private static final int LEE = 1;
    
    public int stoneGameII(int[] piles) {
    
        int[][][] memo = new int[piles.length][2][piles.length+1];
        
        for(int i=0; i < piles.length; i++) {
            Arrays.fill(memo[i][ALEX], -1);
            Arrays.fill(memo[i][LEE], -1);
        }
        
        return findAlexOptimalStone(piles, 0, ALEX, 1, memo);
    }
    
    int findAlexOptimalStone(int[] piles, int ind, int turn, int M, int[][][] memo) {
        
        if ( ind >= piles.length) {
            return 0;
        }
        
        M = Integer.min(M, piles.length);
        
        if ( memo[ind][turn][M] != -1) {
            return memo[ind][turn][M];
        }
 
        int ret;
         
        if (turn == ALEX) {
            ret = 0; 
            int sum =0;
            for(int i=ind, X=1 ; i < ind + (2*M) && i < piles.length; i++, X++) {
                sum += piles[i];
                ret = Integer.max(ret, findAlexOptimalStone(piles, i + 1, LEE, Integer.max(M,X), memo) + sum);
            }
        } else {
            ret = Integer.MAX_VALUE;
            for(int i=ind,  X=1; i < ind + (2*M) && i < piles.length; i++, X++) {
                ret = Integer.min(ret, findAlexOptimalStone(piles, i + 1, ALEX, Integer.max(M,X), memo));
            }
        }
        
        return memo[ind][turn][M] = ret; 
    }
}
