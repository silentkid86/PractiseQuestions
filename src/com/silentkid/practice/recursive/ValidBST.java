package com.silentkid.practice.recursive;

import com.silentkid.practice.node.BSTNode;

public class ValidBST {

    public static boolean validBST(BSTNode node){
        return isValidBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean isValidBST(BSTNode node, int min, int max){
        if(node == null) return true;
        if(node.data > max || node.data < min) return false;

        return isValidBST(node.left, min , node.data) && isValidBST(node.right, node.data + 1,  max);
    }


    public static void main(String args[]) {
        BSTNode root = new BSTNode(5);
        root.left = new BSTNode(2);
        root.right = new BSTNode(7);
        root.left.left = new BSTNode(1);
        root.left.right = new BSTNode(3);
        root.right.right = new BSTNode(8);
        root.right.left = new BSTNode(4);

        System.out.println("Is this a valid BST : " +
                validBST(root));
    }
}
