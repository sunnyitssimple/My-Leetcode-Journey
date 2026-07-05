/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
   
    private int currentCount = 0;
    private int maxCount = 0;
    private Integer previousValue = null;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
      
        inorder(root);
        
       
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        
        inorder(root.left);

       
        if (previousValue != null && root.val == previousValue) {
            currentCount++; 
        } else {
            currentCount = 1; 
        }

        
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();        
            modes.add(root.val);
        } else if (currentCount == maxCount) {
            modes.add(root.val);  
        }

       
        previousValue = root.val;

       
        inorder(root.right);
    }
}
