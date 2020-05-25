class Solution {
    
    boolean[][] dp;
    boolean[][] vis;
    
    public boolean isMatch(String s, String p) {
        
        dp = new boolean[s.length() + 1][p.length() + 1];
        vis = new boolean[s.length() + 1][p.length() + 1];
        
        return isMatch(s.length()-1, p.length()-1, s, p, false);
    }
    
    public boolean isMatch(int ind1, int ind2, String s1, String s2, boolean isStar) {
        
        if (ind1 < 0 && ind2 < 0) {
            return true;
        }
        
        if (ind2 < 0) {
            return false;
        }
        
        if (vis[ind1+1][ind2+1]) {
            return dp[ind1+1][ind2+1];
        }
        vis[ind1+1][ind2+1] = true;
        
        if (s2.charAt(ind2) == '*') {
            return dp[ind1+1][ind2+1] = isMatch(ind1, ind2-1, s1, s2, true);
        }
        
        boolean match = false;
        if (ind1 >=0 &&  (s1.charAt(ind1) == s2.charAt(ind2) || s2.charAt(ind2) == '.')) {
            if (isStar) {
                match = match || isMatch(ind1-1, ind2, s1, s2, isStar);
            }
            match = match || isMatch(ind1-1, ind2-1, s1, s2, false);
        }
        if(isStar) {
           match = match ||  isMatch(ind1, ind2-1, s1, s2, false);
        } 
        
        return dp[ind1+1][ind2+1] = match;
        
    }
}
