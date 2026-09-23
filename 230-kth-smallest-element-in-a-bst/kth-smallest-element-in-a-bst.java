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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        traverse(root, queue, k);
        return queue.peek();
    }
    public void traverse(TreeNode root, Queue<Integer> queue, int k){
        if(root == null) return;

        queue.offer(root.val);
        if(queue.size() > k) queue.poll();

        traverse(root.left, queue, k);
        traverse(root.right, queue, k);
    }
}