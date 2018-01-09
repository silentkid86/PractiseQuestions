package com.silentkid.practice;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.silentkid.practice.node.BSTNode;


public class BST {
	public BSTNode root = null;
	private int size= 0;
	
	public BSTNode searchInt(int d){
		return recursiveSearch(root,d);
	}
	
	private BSTNode recursiveSearch(BSTNode startnode, int d) {
		if(startnode.data == d) return startnode;
		else{
			if(d > startnode.data && startnode.right != null) 
				return recursiveSearch(startnode.right,d);
			
			if(d < startnode.data && startnode.left != null)
				return recursiveSearch(startnode.left,d);
		}
		
		return null; //when none returned from the search above

	}

	public void addInt(int d){
		if(root == null) 
			root = new BSTNode(d);
		else recursiveAdd(this.root,d);
		
		this.size++;
	}
	
	private void recursiveAdd(BSTNode startnode,int d) {
		if( d < startnode.data ){
			if(startnode.left != null)
				recursiveAdd(startnode.left,d);
			else{
				startnode.left = new BSTNode(d);
				startnode.left.parent = startnode;
			}
		}
		if( d > startnode.data ){
			if(startnode.right != null)
				recursiveAdd(startnode.right, d);
			else{
				startnode.right = new BSTNode(d);
				startnode.right.parent = startnode;
			}
			
		}
		
	}

	public void deleteInt(int d){
		BSTNode result = recursiveSearch(root,d);
		
		handleDelete(result);
		
		this.size--;
	}

	private void handleDelete(BSTNode node) {
		if(node.left != null && node.right != null){
			//both children are there
			BSTNode succesor=findSuccesor(node);
			removeSingleChildNode(succesor); //left child is null
			
			BSTNode childCopy = shallowCopy(succesor);//remove references
			
			childCopy.left = node.left;
			childCopy.right = node.right;
			replaceNodeWithAnother(node,childCopy);
			
		}else{
			//either one child is missing
			removeSingleChildNode(node);
		}
		
	}

	private void removeSingleChildNode(BSTNode node) {
		if(node.left == null){
			//right child exists
			BSTNode childNode = node.right;
			replaceNodeWithAnother(node, childNode);
		}else if(node.right == null){
			//left child exist
			BSTNode childNode = node.left;
			replaceNodeWithAnother(node, childNode);
		}
	}

	private BSTNode findSuccesor(BSTNode node) {
		return recursiveGetMin(node.right);
	}

	private void replaceNodeWithAnother(BSTNode deletedNode, BSTNode newNode) {
		updatesParent(deletedNode, newNode);
		
		//if not child then this will be null , for leaf scenario
		//updates child's parent
		if(newNode != null) newNode.parent = deletedNode.parent;
	}

	private void updatesParent(BSTNode deletedNode, BSTNode newNode) {
		if(isRootNode(deletedNode)){
			//root scenario
			//updates root reference in BST 
			this.root = newNode;
		}else{	
			//updates parent's child
			if(deletedNode.parent.data > deletedNode.data){
				//parent's left
				deletedNode.parent.left = newNode;
			}else{
				//parent's right
				deletedNode.parent.right = newNode;
			}
		}
	}

	private boolean isRootNode(BSTNode nodeToCheck) {
		return nodeToCheck.parent == null;
	}
	
	//copy without reference
	private BSTNode shallowCopy(BSTNode c){
		return new BSTNode(c.data);
	}

	public int getSize() {
		return size;
	}

	public BSTNode findMin(){
		if(root == null) //handle extreme case
			return null;
		
		return recursiveGetMin(root);
	}

	private BSTNode recursiveGetMin(BSTNode start) {
		if(start.left == null) 
			return start;
		else
			return recursiveGetMin(start.left);
	}
	
	public BSTNode searchByDFS(int d){
		Stack<BSTNode> stack = new Stack<>();
		stack.push(root);
		return dfs(stack, d);
	}
	
	
	private BSTNode dfs(Stack<BSTNode> stack , int d) {
		BSTNode node = null;
		if(!stack.empty())
			node = stack.pop();
		else
			return node;
		
		if(node.data == d) return node;
		
		//BST vertices only has one parent
		if(node.left != null) stack.push(node.left);
		if(node.right != null)stack.push(node.right);
		
		return dfs(stack,d);
	}
	
	public BSTNode searchByBFS(int d){
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		return bfs(queue, d);
	}

	private BSTNode bfs(Queue<BSTNode> queue, int d) {
		BSTNode node = null;
		if(!queue.isEmpty())
			node = queue.poll();
		else
			return node;
		
		if(node.data == d) return node;
		
		//BST vertices only has one parent
		if(node.left != null) queue.add(node.left);
		if(node.right != null)queue.add(node.right);
		
		return bfs(queue, d );
	}
}


