package com.silentkid.practice.leetcode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int size1 = getlength(l1);
        int size2 = getlength(l2);

        if(size1 < size2){
            l1 = padZeroAtFront(l1,size2 - size1);
        }else{
            l2 = padZeroAtFront(l2, size1 - size2);
        }

        RespNode result = recursiveAdd(l1,l2);

        if(result.carryover > 0){
            ListNode node = new ListNode(result.carryover , result.node);
            return node;
        }


        return result.node;
    }

    private static RespNode recursiveAdd(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return new RespNode(null,0);
        }

        RespNode resp = recursiveAdd(l1.next , l2.next);

        int sum =l1.val + l2.val + resp.carryover;

        ListNode node =new ListNode(sum%10, resp.node);

        return new RespNode(node, sum/10);

    }

    public static int getlength(ListNode l1){
        if(l1 == null){
            return 0;
        }

        return 1 + getlength(l1.next);
    }

    public static ListNode padZeroAtFront(ListNode l1,int depth){
        ListNode zero = null;
        while(depth > 0){
            zero = new ListNode(0);
            zero.next = l1;
            l1 = zero;
            depth--;
        }

        return zero;
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
        }while(l != null);

    }

    static class RespNode {
        ListNode node;
        int carryover;

        RespNode(ListNode node, int carryover){
            this.node = node;
            this.carryover = carryover;
        }

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
