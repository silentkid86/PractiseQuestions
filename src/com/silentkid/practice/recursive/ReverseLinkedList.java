package com.silentkid.practice.recursive;

import com.silentkid.practice.node.LinkedListNode;

public class ReverseLinkedList {
	
	private static LinkedListNode newhead= new LinkedListNode();

	public static void main(String[] argz){
		
		LinkedListNode head = new LinkedListNode(); 
		head.next= createList();
		
		reverseList(head,null);
		
		System.out.println("heree");
		
	}

	private static LinkedListNode reverseList(LinkedListNode curr,LinkedListNode prev) {
		
		if (curr.next == null) {
			newhead = curr;
 
            /* Update next to prev node */
            curr.next = prev;
            return null;
        }
 
        /* Save curr->next node for recursive call */
		LinkedListNode next1 = curr.next;
 
        /* and update next ..*/
        curr.next = prev;
 
        reverseList(next1, curr);
        return newhead ;
	}

	private static LinkedListNode createList() {
		
		LinkedListNode one = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		
		one.next = two;
		two.next = three;
		
		return one;
	}

}
