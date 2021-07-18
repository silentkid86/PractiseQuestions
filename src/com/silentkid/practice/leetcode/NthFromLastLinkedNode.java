package com.silentkid.practice.leetcode;

import com.silentkid.practice.linkedlist.AddingTwoNumbers;
import com.silentkid.practice.linkedlist.SwapTwoNodes;

public class NthFromLastLinkedNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode wrapper = new ListNode();
        wrapper.next = head;
        ListNode lastPointer = wrapper, nthPlusOneLastPointer = wrapper;
        int i = n;
        while(i > 0){
            lastPointer = lastPointer.next;
            i--;
        }

        while(lastPointer.next != null){
            lastPointer = lastPointer.next;
            nthPlusOneLastPointer = nthPlusOneLastPointer.next;
        }

        //remove the next for the second pointer
        ListNode nthNode =nthPlusOneLastPointer.next;
        nthPlusOneLastPointer.next = nthNode.next;

        return wrapper.next;
    }

    public static void main(String[] argz){
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3

                       )));

//        ListNode head = new ListNode(1);

        ListNode nodes= removeNthFromEnd(head,2);

        int s = nodes.val;
    }

    static class ListNode {
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
