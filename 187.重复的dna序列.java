/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        // 遍历数组 因为下面的数据一次截取10个数据所以 -9
        for (int i = 0; i < s.length() - 9; i++) {
            // 截取字符串存入 a
            String a = s.substring(i, i + 10);
            // 判断 map 集合里面是否存在这个字符串
            if (map.containsKey(a)) {
                // 进入到这里就代表出现某个字符串第 >=2 次了
                // 使用 set 不重复的特性存取字符串最后返回
                set.add(a);
            } else {
                map.put(a, 1);
            }
        }
        return new ArrayList<>(set);
    }
}
// @lc code=end
