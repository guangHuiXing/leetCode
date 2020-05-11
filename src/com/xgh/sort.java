package com.xgh;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName sort
 * @Description
 * @Author xinggh
 * @Date 2020/5/9 9:48
 * @Version 1.0
 **/
public class sort {

    /**
     * 2. 两数相加
     * 给出两个     非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点
     * 只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;

        ListNode ll = new ListNode(0);
        ListNode cur = ll;
        while (l1 != null || l2 != null) {
            sum = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry);

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return ll.next;

    }

    public static ListNode reverse(ListNode l1) {
        if (l1 == null) {
            return null;
        }
        ListNode head = l1;
        ListNode next = l1.next;
        head.next = null;
        while (next != null) {
            ListNode next2 = next.next;
            next.next = head;
            head = next;
            next = next2;
        }
        return head;
    }

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(c), start);
            }

            max = Math.max(max, i - start + 1);
            map.put(s.charAt(i), i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
       /* ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(4);
        l1.next = l2;

        l3.next = l4;
       *//* ListNode reverse = reverse(l1);
        System.out.println(reverse.val);*//*
        addTwoNumbers(l1, l3);*/

        lengthOfLongestSubstring("abca");
    }
}
