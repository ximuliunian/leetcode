/*
 * @lc app=leetcode.cn id=2760 lang=java
 *
 * [2760] 最长奇偶子数组
 */

// @lc code=start
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        // 返回值
        int num = 0;
        // 进行跳跃式增加
        int temp;
        // 遍历数组,增加数组比较是正常++大还是跳跃式大
        for (int left = 0; left < nums.length; left = Math.max(left + 1, temp)) {
            int off = 1; // 判断奇偶数
            int offTemp = 1; // 判断二次偶数
            temp = left;
            // num[left]是偶数并且小于等于threshold而且num要小于等于left
            if (nums[left] % 2 == 0 && nums[left] <= threshold && num <= left) {
                int right = left + 1; // 本身满足条件就要加一
                // 循环遍历
                while (right < nums.length) {
                    // 判断新的数据是否是奇偶数并且是否小于等于threshold
                    if (nums[right] % 2 == off && nums[right] <= threshold) {
                        // 第二次是偶数时并且offTemp开关为1时进入
                        if (off == 0 && offTemp == 1) {
                            temp = right; // 中间数用于减少循环次数
                            offTemp = 0; // 关闭开关
                        }
                        // 右下标+1
                        right++;
                        // 奇数转偶数,偶数转奇数
                        off = off == 1 ? 0 : 1;
                    } else
                        break;
                }
                // 判断谁最大
                num = Math.max(num, right - left);
            }
        }
        return num;
    }
}
// @lc code=end
