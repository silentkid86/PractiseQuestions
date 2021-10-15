package com.silentkid.practice.leetcode;

public class ReverseASublist {

    public static ListNode reverseSubList(ListNode head, int start, int end) {
        ListNode handle = head;
        ListNode before = null;
        ListNode curr = head;
        int counter = 0;
        while(counter < start - 1){
            before = curr;
            curr = curr.next;
            counter ++;
        }
        // sublist's last node after reverse
        ListNode newLast = curr;

        ListNode prev = null;
        while(counter < end){
            ListNode tmp = curr.next;
            curr.next = prev; //reversing the link
            prev = curr;
            curr = tmp;
            counter ++;
        }

        //now curr is the node after sublist
        //link the last node of the sublist
        newLast.next = curr;

        //check if start is 1 , meaning there is no before
        if(before != null)
            before.next = prev;
        else
            handle = prev;


        return handle;
    }
    
    
    public static void main(String[] argx){
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode output = reverseSubList(input,2,4);
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
