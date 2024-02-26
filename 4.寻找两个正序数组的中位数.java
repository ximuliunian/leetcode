/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 因为是只需要中间数，所以只需要取一半就行了，就是让 数组1 和 数组2 的长度相加并除以 2 再加上一个 1 是为了奇数的存在
        int i1 = (nums1.length + nums2.length) / 2 + 1;
        // 创建一个数组
        int[] mergeArrays = new int[i1];
        int i = 0; // nums1下标自走
        int j = 0; // nums2下标自走
        // 循环一遍数据
        for (int k = 0; k < i1; k++) {
            // 这两步是当其中一组数据走完了，那么直接把其余数据接上末尾即可
            if (i == nums1.length) {
                mergeArrays[k] = nums2[j];
                j++;
                continue;
            } else if (j == nums2.length) {
                mergeArrays[k] = nums1[i];
                i++;
                continue;
            }

            // 判断两个数那个大那个小，小的那个进入新数组
            if (nums1[i] <= nums2[j]) {
                mergeArrays[k] = nums1[i];
                i++;
            } else {
                mergeArrays[k] = nums2[j];
                j++;
            }
        }
        // 最后判断是奇数还是偶数，以决定最终结果
        if ((nums1.length + nums2.length) % 2 == 1) {
            return mergeArrays[i1 - 1];
        } else {
            return (double) (mergeArrays[i1 - 1] + mergeArrays[i1 - 2]) / 2;
        }
    }
}
// @lc code=end
