/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        
        if (root == null) {
            return result;
        }
        
        curLevel.offer(root);
        
        while (!curLevel.isEmpty()) {
            
            int size = curLevel.size();
            List<Integer> level = new ArrayList<Integer>();
            
            for (int i = 0; i < size; i++) {
                
                if (curLevel.peek().left != null) {
                    curLevel.offer(curLevel.peek().left);
                }
                if (curLevel.peek().right != null) {
                    curLevel.offer(curLevel.peek().right);
                }
                level.add(curLevel.poll().val);
            }
            result.add(level);
        }
        
        return result;
        
    }
}


public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        
        if (root == null) {
            return result;
        }
        
        curLevel.add(root);
        
        while (curLevel.size() != 0) {
            List<Integer> level = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode node : curLevel) {
                level.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            result.add(level);
            curLevel = nextLevel;
        }
        
        return result;
        
    }
}
