/*
 * @lc app=leetcode.cn id=2609 lang=java
 *
 * [2609] 最长平衡子字符串
 */

// @lc code=start
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int o = 0; // 0 的个数
        int l = 0; // 1 的个数
        int frds = 0; // 返回的总数
        int boo = 1; // 判断所用
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 根据题意所知,平衡子串开头都是 0
            // 判断是否是 0 ,是的话 o++
            // 不是的话, l++
            if (s.charAt(i) == '0') {
                // 当 boo = 3 的时候就代表着已经完成了一次平衡子串的数据采集
                if (boo == 3) {
                    // 判断是0的数据多还是1的数据多
                    int temp = o > l ? (l * 2) : (o * 2);
                    // 判断是以前的数据大还是新的数据大
                    frds = Math.max(frds, temp);
                    // 把所有数据初始化
                    o = 0;
                    l = 0;
                    boo = 1;
                }
                o++;
                // 判断boo是否为基数
                if ((boo & 1) == 1)
                    boo++;
            } else {
                // 这代表本次是1开头的,所以数据作废
                if (boo == 1)
                    continue;
                l++;
                if ((boo & 1) == 0)
                    boo++;
            }
        }
        // 循环最后会有数据最大到但是循环结束的情况,所以,最后在判断一下
        if (boo == 3) {
            int temp = o > l ? (l * 2) : (o * 2);
            frds = Math.max(frds, temp);
        }

        return frds;
    }
}
// @lc code=end