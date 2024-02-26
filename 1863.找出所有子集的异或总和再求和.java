/*
 * @lc app=leetcode.cn id=1863 lang=java
 *
 * [1863] 找出所有子集的异或总和再求和
 */

// @lc code=start
class Solution {
    int num = 0; // 返回值
    int tmp = 0; // 中间值

    public int subsetXORSum(int[] nums) {
        diGui(nums, 0); // 开始递归
        return num;
    }

    public void diGui(int[] nums, int idx) {
        // 判断是否递归到头
        if (idx == nums.length)
            return;
        // 模本次的值
        tmp ^= nums[idx];
        // 把模的值赋值给num
        num += tmp;
        // 开始向像下一次递归，下标加一
        diGui(nums, idx + 1);
        // 丢弃对应的数值
        tmp ^= nums[idx];
        // 进行下一次递归
        diGui(nums, idx + 1);
    }
}
// @lc code=end
