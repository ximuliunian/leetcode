/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // max 用于存放共有几个符合要求的数字
        int[] max = new int[spells.length];
        Arrays.sort(potions); // 顺序排序
        // 循环遍历
        for (int i = 0; i < max.length; i++) {
            // 找出最小值用于二分比较
            double tem = (success * 1.0) / spells[i];

            // 两个下标位置
            int low = 0;
            int high = potions.length - 1;
            // 查找符合要求的最小下标
            while (low < high) {
                // 从中间查找
                int mid = (low + high) / 2;
                // 满足条件，往右边查，看看还有没有更小的
                if (potions[mid] >= tem)
                    high = mid;
                // 太小了，往右边移一位
                else
                    low = mid + 1;
            }
            // 判断这个是否符合要求，符合要求的话把数据给max
            if ((potions[high] * 1.0) * spells[i] >= success) {
                max[i] = potions.length - high;
            }

        }
        return max;
    }
}
// @lc code=end
