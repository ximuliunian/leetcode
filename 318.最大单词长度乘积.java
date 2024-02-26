/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        int max = 0; // 最大值
        // 定义一个存放二进制数的int数组
        int[] a = new int[words.length];
        // 先把所有的数据都转换成二进制并存入a数组里面
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                a[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
        // 直接遍历判断是否数组
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((a[i] & a[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
// @lc code=end
