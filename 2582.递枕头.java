/*
 * @lc app=leetcode.cn id=2582 lang=java
 *
 * [2582] 递枕头
 */

// @lc code=start
class Solution {
    public int passThePillow(int n, int time) {
        int a = n * 2 - 2; // 先把来回一趟的秒数算出来
        int b = time % a; // 把还剩多少秒求出来
        // 判断剩余的秒数是否大于趟数的一半
        // 如果大于,就代表是往左走的数据
        // 如果不大于,就代表是往右的走的数据
        if ((a / 2) < b) {
            return n - (b - (a / 2));
        } else {
            return 1 + b;
        }
    }
}
// @lc code=end
