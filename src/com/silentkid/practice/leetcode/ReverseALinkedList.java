package com.silentkid.practice.leetcode;

public class ReverseALinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) return head;
//        ListNode p = dfs(head);

        ListNode p = iterative(head);

        return p;

    }

    public static ListNode iterative(ListNode node) {
        ListNode prev = null;
        while(node != null){
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }

        return prev;
    }

    public static ListNode dfs(ListNode node) {

        if (node.next == null) {
            return node;
        }

        ListNode last = dfs(node.next);

        node.next.next = node;

        node.next = null;

        return last;
    }

    public static void main(String[] argx){
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode output = reverseList(input);
        while(output!=null){
            System.out.println(output.val);
            output = output.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
