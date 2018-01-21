package com.silentkid.practice.frombook;

import com.silentkid.practice.node.LinkedListNode;

/**
 * linkedlist stores number in reverse order : 7 -> 1 -> 6   = 617
 * 
 * adds 2 linkedlists together and get the result.
 * 
 * @author Tidus
 *
 */
public class LinkedListAdd {

	public static void main(String[] argz){
		
		LinkedListNode head1 = new LinkedListNode();
		LinkedListNode head2 = new LinkedListNode();
		
		head1.next = new LinkedListNode(7);
		head1.next.next = new LinkedListNode(1);
		head1.next.next.next = new LinkedListNode(6);
		
		head2.next = new LinkedListNode(5);
		head2.next.next = new LinkedListNode(9);
		head2.next.next.next = new LinkedListNode(6);
		
		LinkedListNode result= addTwoLinkedList(head1.next,head2.next,0);
		
		System.out.println(result);
	}

	private static LinkedListNode addTwoLinkedList(LinkedListNode n1,
			LinkedListNode n2 , int carry) {
		
		if(n1 == null && n2== null && carry == 0){
			return null;
		}
		
		int v  = carry ;
		if( n1 != null ) v += n1.data;
		if( n2 != null ) v += n2.data;
		
		int remainder = v % 10 ;
		LinkedListNode r = new LinkedListNode(remainder);
		
		
		r.next = addTwoLinkedList(n1 == null ? null : n1.next , 
				n2 == null ? null : n2.next , v > 10 ? 1 : 0);
		
		return r;
	}
	
	
	

//	private static int addTwoLinkedList(LinkedListNode head1,
//			LinkedListNode head2) {
//		// TODO Auto-generated method stub
//		
//		int x = getDigitFrom(head1);
//		int y = getDigitFrom(head2);
//		
//		return x + y;
//	}
//
//	private static int getDigitFrom(LinkedListNode head) {
//		
//		StringBuffer stringBuffer = new StringBuffer();
//		
//		traverseLinkedList(head.next, stringBuffer);
//		
//		return Integer.parseInt(stringBuffer.toString());
//	}
//
//	private static void traverseLinkedList(LinkedListNode node, StringBuffer stringBuffer) {
//		
//		if(node.next == null){
//			stringBuffer.append(node.data);
//			return;
//		}
//		
//		traverseLinkedList(node.next,stringBuffer);
//		stringBuffer.append(node.data);
//		
//		
//		return ;
//		
//	}
	
}
