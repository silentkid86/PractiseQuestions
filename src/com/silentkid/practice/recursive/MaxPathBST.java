package com.silentkid.practice.recursive;

import com.silentkid.practice.node.BSTNode;

public class MaxPathBST {
	
	public static int getMaxPathValue (BSTNode node, int result){

		if(null == node)
			return 0;

		int l = getMaxPathValue(node.left, result);
		int r = getMaxPathValue(node.right , result);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data, node.data);

		// Max Top represents the sum when the Node under
		// consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		//compare this local max result with previous result
		result = Math.max(result, max_top);

		return result;
		
	}

	public static void main(String args[]) {
		BSTNode root = new BSTNode(10);
		root.left = new BSTNode(2);
		root.right = new BSTNode(10);
		root.left.left = new BSTNode(20);
		root.left.right = new BSTNode(1);
		root.right.right = new BSTNode(-25);
		root.right.right.left = new BSTNode(3);
		root.right.right.right = new BSTNode(4);
		System.out.println("maximum path sum is : " +
				getMaxPathValue(root,Integer.MIN_VALUE));
	}

}
