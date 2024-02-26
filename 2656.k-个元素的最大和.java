/*
 * @lc app=leetcode.cn id=2656 lang=java
 *
 * [2656] K 个元素的最大和
 */

// @lc code=start
class Solution {
    public int maximizeSum(int[] nums, int k) {
        // 定义返回值
        int max = 0;
        // 找出最大值
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 返回数就是max + (max+1) + (max+2) + … k-1
        // 那么共同点就是都有 max 只需要先把 max 的值取出来剩余的就是 （0+1+2+3+…+k-1）
        // 前面 k*max 取所有的max；后面的 k*(k-1)/2 就是取后面的部分，这两个部分相加就欧克了
        return k * max + k * (k - 1) / 2;
    }
}
// @lc code=end
