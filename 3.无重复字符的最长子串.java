/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {

    /*
     * 第一版
     * public int lengthOfLongestSubstring(String s) {
     * int num = 0; // 返回数最大
     * int numTem = 0; // 中间数
     * // 用于判断是否存在相同字符
     * List<Character> list = new ArrayList<>();
     * // 循环遍历
     * for (int i = 0; i < s.length(); i++) {
     * // 如果里面有相同的字符，那么就一直删除第一个数，知道里面没有相同的字母为止
     * while (list.contains(s.charAt(i))) {
     * list.remove(0);
     * // 中间数 --
     * numTem--;
     * }
     * // 每次循环，中间数都加一，并且进行大小判断
     * numTem++;
     * num = Math.max(numTem, num);
     * // 增加数据
     * list.add(s.charAt(i));
     * }
     * return num;
     * }
     */

    public int lengthOfLongestSubstring(String s) {
        int num = 0; // 返回值
        int left = 0; // 左边下标
        // 用于记录字符和对应的下标
        Map<Character, Integer> map = new HashMap<>();
        // 遍历循环
        for (int i = 0; i < s.length(); i++) {
            // 判断里面是否存在对应字符
            if (map.containsKey(s.charAt(i))) {
                // left 和 对应的下标判断大小（这一步是为了重复字符出现在前面）
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 存入数据
            map.put(s.charAt(i), i);
            // 判断 num 和 "下标" 谁大
            num = Math.max(num, i - left + 1);
        }
        return num;
    }
}
// @lc code=end
