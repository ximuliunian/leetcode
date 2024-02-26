/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean once = true; // 用作开关使用
        int[] num = new int[3]; // 用节点求和
        int carry1 = 0; // 判断是否进位
        int carry2 = 0; // 判断数据之间增加是否为10
        ListNode head = null; // 首节点
        ListNode p = null; // 运动节点
        // 等到两个都为空时结束循环
        while (l1 != null || l2 != null) {
            // 判断 l1 节点是否到头
            if (l1 != null) {
                num[0] = l1.val;
                l1 = l1.next;
            } else {
                num[0] = 0;
            }

            // 判断 l2 节点是否到头
            if (l2 != null) {
                num[1] = l2.val;
                l2 = l2.next;
            } else {
                num[1] = 0;
            }
            // 求出 l1 + l2 的和
            num[2] = num[1] + num[0];
            // 判断是否是第一次,如果是的话,创建一个头节点
            if (once) {
                head = new ListNode(num[2] % 10);
                p = head;
                once = false; // 关闭开关
            } else {
                // 先把和模10加上进位判断是否是10
                int temp = num[2] % 10 + carry1;
                if (temp == 10) {
                    carry2 = 1;
                    temp = 0;
                } else {
                    carry2 = 0;
                }
                // 采用尾插法
                p.next = new ListNode(temp);
                p = p.next;
            }
            // 判断是否需要进位
            carry1 = (num[2] / 10) + carry2; // 判断是否进位
            // 当两个都走到头了并且进位还有数据,那么就为这个进位创建一个节点
            if (l1 == null && l2 == null && carry1 != 0) {
                p.next = new ListNode(carry1);
            }
        }
        return head;
    }
}
// @lc code=end
