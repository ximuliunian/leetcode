/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // 结果集
        List<Integer> list = new ArrayList<>();
        // 如果 root 为 null 的话直接返回结果集
        if (root == null)
            return list;

        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 入队
        queue.add(root);
        // 每层元素个数
        int len = queue.size();

        // 遍历
        while (true) {
            // 层次遍历
            TreeNode poll = queue.poll();
            // 左节点入队
            if (poll.left != null)
                queue.add(poll.left);
            // 右节点入队
            if (poll.right != null)
                queue.add(poll.right);

            // 上一层剩余元素
            len--;

            // 判断上一层元素是否出队完
            if (len == 0) {
                // 若上一层无元素，则把最后一个元素加入结果集
                list.add(poll.val);
                // 重置len的层节点个数
                len = queue.size();
            }
            // 如果充值完成还是0那么二叉树遍历完成跳出循环
            if (len == 0) {
                break;
            }
        }
        // 返回结果集
        return list;
    }
}
// @lc code=end
