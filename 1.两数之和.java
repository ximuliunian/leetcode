/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 用来存放下标数据
        int[] a = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 判断所谓的和减去其中数组中的数的差值在 map 集合中是否存在
            // 如果不存在,就为 map 集合进行添加这个数据
            // 如果存在,那么就返回这个数据和现在被减数的下标
            if (map.containsKey(target - nums[i])) {
                a[0] = map.get(target - nums[i]);
                a[1] = i;
                return a;
            }
            map.put(nums[i], i);
        }
        return a;
    }
}
// @lc code=end
