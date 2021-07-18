package com.silentkid.practice.linkedlist;


public class AddingTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        appendZeroAtFront(l1,l2);

        ListNode n =recursiveAddTwoNumber(l1 , l2 , 0);

        return n;
    }

    /**
     * Both l1 and l2 should be same length now, do DFS .
     *
     */
    private static ListNode recursiveAddTwoNumber(ListNode l1, ListNode l2,int co) {

        if(null == l1 && null == l2){
            if(co > 0)
                return new ListNode(co);
            else
                return null;
        }

        int sumResult = l1.val + l2.val + co;
        int nodeVal = sumResult % 10;
        int carryOver = sumResult / 10;

        ListNode nextNode=recursiveAddTwoNumber(l1.next , l2.next , carryOver);
        ListNode current = new ListNode(nodeVal);
        current.next = nextNode;

        return current;
    }

    private static void appendZeroAtFront(ListNode l1,ListNode l2) {
        if(l1.next == null && l2.next==null){
            return;
        }
        if(l1.next == null){
            l1.next = new ListNode(0);
        }else if(l2.next == null){
            l2.next = new ListNode(0);
        }

        appendZeroAtFront(l1.next , l2.next);

    }

    private static int getLength(ListNode l) {
        if(null == l.next){
            return 1;
        }

        return getLength(l.next) + 1;
    }

    public static void main(String[] argz){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);


        ListNode l = addTwoNumbers(l1, l2);

        do{
            System.out.println(l.val);
            l = l.next;
        }while(l.next != null);

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
