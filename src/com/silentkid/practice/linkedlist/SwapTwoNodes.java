package com.silentkid.practice.linkedlist;

import java.util.List;

public class SwapTwoNodes {
    //recursive
    public static ListNode recurSwapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;

        head = temp;
        head.next.next = recurSwapPairs(head.next.next);
        return head;
    }

    //iterative
    public static ListNode swapPairs(ListNode head) {

        ListNode head_ref = new ListNode();
        head_ref.next = head;
        //two pointer
        ListNode pointer=head_ref;
        while(pointer != null){
            ListNode current_pointer = pointer.next;
            if(current_pointer == null){
                break;
            }
            ListNode second_pointer = current_pointer.next;
            if(second_pointer == null){
                break;
            }
            pointer.next = second_pointer;
            current_pointer.next = second_pointer.next;
            second_pointer.next = current_pointer;

            pointer = current_pointer;
        }

        return head_ref.next;
    }

    public static void main(String[] argz){
        ListNode head = new ListNode(1,
                new ListNode(2 ,
                        new ListNode(3 ,
                                new ListNode(4))));

        ListNode nodes= recurSwapPairs(head);

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
