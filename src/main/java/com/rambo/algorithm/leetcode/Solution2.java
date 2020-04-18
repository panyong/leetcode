package com.rambo.algorithm.leetcode;


import java.util.BitSet;
import java.util.Stack;

/**
 * 不使用链表翻转
 * 1. 辅助空间： 两个Stack
 * 2. 两个链表分别入栈，短的链表补0
 * 3. 出栈，相加，考虑进位
 **/
public class Solution2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        // 入栈
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }

        // 出栈，相加，考虑进位
        int carry = 0;
        int sum = 0;
        ListNode ret = new ListNode(0);
        while (s1.iterator().hasNext() || s2.iterator().hasNext() || carry > 0) {

            sum += s1.iterator().hasNext() ? s1.pop() : 0;
            sum += s2.iterator().hasNext() ? s2.pop() : 0;
            sum += carry;
            ListNode temp = new ListNode(sum >= 10 ? sum - 10 : sum);

            carry = sum >= 10 ? 1 : 0;
            sum = 0;
            // 头插法
            temp.next = ret.next;
            ret.next = temp;
        }

        return ret.next;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode l1 = getList(new int[]{7, 2, 4, 3});
        ListNode l2 = getList(new int[]{5, 6, 4});

        ListNode ret = solution.addTwoNumbers(l1, l2);

        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }

    }

    private static ListNode getList(int[] ary) {
        ListNode listNode = null, p = null;
        for (int i : ary) {
            if (listNode == null) {
                listNode = new ListNode(i);
                p = listNode;
            } else {
                p.next = new ListNode(i);
                p = p.next;
            }
        }

        return listNode;
    }
}
