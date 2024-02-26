/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 定义一个节点用来接收 head 的数据
        ListNode t = head;
        // 判断本身和本身的下一个不是空那么就循环
        while (t != null && t.next != null) {
            // 判断本身的值与本身下一个的值是否相等
            if (t.val == t.next.val) {
                // 是的话，就删除掉本身的下一个节点，再次循环判断
                t.next = t.next.next;
            } else {
                // 不是的话，前往本身的下一个节点
                t = t.next;
            }
        }
        // 最终返回 head 值
        return head;
    }
}
// @lc code=end
