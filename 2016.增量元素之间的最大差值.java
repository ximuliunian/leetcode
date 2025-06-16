/*
 * @lc app=leetcode.cn id=2016 lang=java
 *
 * [2016] 增量元素之间的最大差值
 */

// @lc code=start
class Solution {

  public int maximumDifference(int[] nums) {
    // return solution_1(nums);
    return solution_2(nums);
  }

  /**
   * 通过设置最大值和最小值来快速比较
   */
  public int solution_2(int[] nums) {
    int maxNum = -1;
    int minNum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= minNum) {
        minNum = nums[i];
      } else {
        int temp = nums[i] - minNum;
        maxNum = maxNum > temp ? maxNum : temp;
      }
    }

    return maxNum;
  }

  /**
   * 使用双 for 循环来逐个比较
   */
  public int solution_1(int[] nums) {
    int result = -1;

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] <= nums[i]) continue;
        int tempReslut = nums[j] - nums[i];
        result = result > tempReslut ? result : tempReslut;
      }
    }

    return result;
  }
}
// @lc code=end
