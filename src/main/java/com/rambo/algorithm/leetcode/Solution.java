package com.rambo.algorithm.leetcode;


import java.util.List;
import java.util.Stack;

/**
 * 0. 辅助空间：Stack
 * 1. 遍历两个链表：翻转
 * 2. 遍历两个链表：相加 & 入栈
 * 3. 出栈：输出结果
 **/
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }

        l1 = reversal(l1);
        l2 = reversal(l2);

        Stack<ListNode> stack = new Stack<>();
        // 链表相加
        boolean flag = true;
        int plus = 0;
        while (flag) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;

                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                sum = l2.val;
                l2 = l2.next;
            } else {
                flag = false;
            }
            sum += plus;
            plus = 0;
            if (sum >= 10){
                stack.push(new ListNode(sum  - 10));
                plus = 1;
            } else {
                stack.push(new ListNode(sum));
            }
        }

        // 出栈
        ListNode ret = popFromStack(stack);

        return ret;
    }

    // 链表翻转
    private ListNode reversal(ListNode l) {
        Stack<ListNode> stack = new Stack<>();

        while (l != null) {
            stack.push(new ListNode(l.val));
            l = l.next;
        }

        return popFromStack(stack);
    }

    private ListNode popFromStack(Stack<ListNode> stack) {
        ListNode ret = null, p = null;

        while (stack.iterator().hasNext()) {
            if (ret == null) {
                ret = stack.pop();
                ret = ret.val == 0 ? null : ret;
                p = ret;
            } else {
                p.next = stack.pop();
                p = p.next;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = getList(new int[]{5});
        ListNode l2 = getList(new int[]{5});

        ListNode ret = solution.addTwoNumbers(l1, l2);

        while (ret != null){
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
