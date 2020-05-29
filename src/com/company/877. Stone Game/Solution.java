class Solution {
    
    private final static int ALEX = 1;
    private final static int LEE = 2;
    
    public boolean stoneGame(int[] piles) {
        
        int memo[][] = new int[piles.length][piles.length]; 
        for (int i=0; i<piles.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        int totalStone = 0; 
        for (int stone : piles) {
            totalStone+= stone;
        }
    
        int alexStone = findStoneForAlex(piles, 0, piles.length-1, ALEX, memo); 
        int leeStone = totalStone - alexStone; 
        
        return (alexStone > leeStone); 
    }
    
    public int findStoneForAlex(int[] piles, int start, int end, int player, int[][] memo) {
        
        if ( start > end ) {
            return 0;
        }
        
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        
        if (player == ALEX) {
            return memo[start][end] = Integer.max(findStoneForAlex(piles, start+1, end, LEE, memo) + piles[start],
                                 findStoneForAlex(piles, start, end-1, LEE, memo) + piles[end]) ;
        } else {
            return memo[start][end] = Integer.min(findStoneForAlex(piles, start+1, end, ALEX, memo),
                                 findStoneForAlex(piles, start, end-1, ALEX, memo)) ;
        }
    }
    
}
