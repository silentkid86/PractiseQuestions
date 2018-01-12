import static org.junit.Assert.*;

import org.junit.Test;

import com.silentkid.practice.BST;
import com.silentkid.practice.node.BSTNode;


public class BSTTEst {
	
	@Test
	public void testAdd() {
		BST tree = new BST();
		tree.addInt(10);
		assertEquals(10, tree.root.data);
	}
	
	@Test
	public void testAdding4nodes() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(8);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(13);
		
		assertEquals(5, tree.getSize());
		
		BSTNode root = tree.root;
		assertEquals(10, root.data);
		assertEquals(8, root.left.data);
		assertEquals(15, root.right.data);
		
		BSTNode rootRight = root.right;
		assertEquals(13, rootRight.left.data);
		
	}
	
	@Test
	public void testSearch() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(8);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(13);
		
		assertEquals(5, tree.getSize());
		
		BSTNode result = tree.searchInt(13);
		assertEquals(13, result.data);
	}
	
	@Test
	public void testDeleteLeftChild() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(8);
		tree.addInt(9);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(13);
				
		tree.deleteInt(15);
		assertEquals(13, tree.root.right.data);
	}
	
	@Test
	public void testDeleteRightChild() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(8);
		tree.addInt(9);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(17);
				
		tree.deleteInt(15);
		assertEquals(17, tree.root.right.data);
	}
	
	@Test
	public void testDeleteLeaf() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(8);
		tree.addInt(9);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(13);
				
		tree.deleteInt(13);
		assertEquals(15, tree.root.right.data);
		assertNull(tree.root.right.left);
	}
	
	@Test
	public void testDeleteNodeWith2Children() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(7);
		tree.addInt(9);
		tree.addInt(4);
		tree.addInt(8);
		tree.addInt(15);
		tree.addInt(13);
				
		tree.deleteInt(7);
		assertEquals(8, tree.root.left.data);
		assertNull(tree.root.left.right.left);
	}
	
	
	@Test
	public void testDeleteRoot() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(7);
		tree.addInt(9);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(13);
				
		tree.deleteInt(10);
		assertEquals(13, tree.root.data);
		assertNull(tree.root.right.left);
	}
	
	@Test
	public void testSearchByDFS() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(7);
		tree.addInt(9);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(13);
				
		BSTNode result = tree.searchByDFS(15);
		assertEquals(15,result.data);
		
	}
	
	@Test
	public void testSearchByBFS() {
		BST tree = new BST();
		tree.addInt(10);
		tree.addInt(7);
		tree.addInt(9);
		tree.addInt(4);
		tree.addInt(15);
		tree.addInt(13);
				
		BSTNode result = tree.searchByBFS(4);
		assertEquals(4,result.data);
		
	}

	
}
