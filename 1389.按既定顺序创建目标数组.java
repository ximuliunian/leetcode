/*
 * @lc app=leetcode.cn id=1389 lang=java
 *
 * [1389] 按既定顺序创建目标数组
 */

// @lc code=start
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        // 主要使用 list 集合,根据 list 集合的特性在相同的位置插入元素,那么原来这个位置的元素就会后移
        List<Integer> list = new ArrayList<>();
        // 遍历数组
        for (int i = 0; i < index.length; i++) {
            // 在指定位置插入指定元素
            list.add(index[i], nums[i]);
        }
        // 定义一个数组
        int[] target = new int[list.size()];
        // 把集合里面的数据给这个数组
        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
// @lc code=end
