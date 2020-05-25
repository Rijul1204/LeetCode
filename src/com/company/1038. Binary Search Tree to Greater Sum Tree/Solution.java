/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        
        findSum(root, 0);
        return root;
    }
    
    public int findSum(TreeNode root, int greaterSum) {
        
        if (root == null) {
            return 0;
        }
        
        int sum = bstToGst(root.right, greaterSum) + root.val;
        root.val = sum + greaterSum;
            
        sum+= bstToGst(root.left, root.val);
            
        return sum;
        
    }
}
