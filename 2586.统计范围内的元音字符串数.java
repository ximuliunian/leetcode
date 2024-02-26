/*
 * @lc app=leetcode.cn id=2586 lang=java
 *
 * [2586] 统计范围内的元音字符串数
 */

// @lc code=start
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            // 调用 isJudgment 方法判断第一个和最后一个字符是否是元音字母
            // 是的话 sum++ 最后返回 sum
            if (isJudgment(words[i].charAt(0)) && isJudgment(words[i].charAt(words[i].length() - 1))) {
                sum++;
            }
        }
        return sum;
    }

    // 传过来的值判断是否有元音字母的
    public boolean isJudgment(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
}
// @lc code=end
