package com.silentkid.practice.frombook;

import com.silentkid.practice.node.LinkedListNode;

public class KthElementLinkedList {

	public static void main(String[] argz){
		
		LinkedListNode head1 = new LinkedListNode();
		
		head1.next = new LinkedListNode(7);
		head1.next.next = new LinkedListNode(1);
		head1.next.next.next = new LinkedListNode(6);
		head1.next.next.next.next = new LinkedListNode(4);
		head1.next.next.next.next.next = new LinkedListNode(2);
		head1.next.next.next.next.next.next = new LinkedListNode(9);
		head1.next.next.next.next.next.next.next = new LinkedListNode(8);
//		head1.next.next.next.next.next.next.next.next = new LinkedListNode(81);

		
		LinkedListNode result= midElement(head1.next,head1.next, 2);
		
		System.out.println(result.data);
		
		
		LinkedListNode nextNode = head1.next;
		int k = 1;
		for(int i=0; i< k ; i++){
			nextNode = nextNode.next;
			if(nextNode == null) System.out.println("length is smaller");
		}
		LinkedListNode result1= kthElementFromLast(head1.next,nextNode, k);
		
		System.out.println(result1.data);
	}

	private static LinkedListNode kthElementFromLast(LinkedListNode p1,LinkedListNode p2, int k) {
		if(p2 == null || p2.next == null){
			return p1;
		}
		
		return kthElementFromLast(p1.next, p2.next, k);
	}

	private static LinkedListNode midElement(LinkedListNode p1,LinkedListNode p2, int k) {
		if(p2 == null || p2.next == null){
			return p1;
		}
		LinkedListNode nextNode = p2;
		
		for(int i=0; i< k; i++){
			if(nextNode == null) nextNode=null;
			else nextNode = nextNode.next;
			
		}
		
		return midElement(p1.next, nextNode ,k);
	}
}
