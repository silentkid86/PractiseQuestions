package com.silentkid.practice.node;

public class LinkedListNode {
	
	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int d){
		super();
		this.data = d;
	}

	public LinkedListNode() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		if(next != null)
			return data + next.toString();
		
		return String.valueOf(data);
	}
}
