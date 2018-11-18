package binarysearchtrees;

import binarytrees.Traversal;
import util.TreeNode;

public class ConstructFromPreOrder {

	
	static class Index
	{
		int preorderIndex = 0;
	}
	
	 Index index = new Index();
	 
	    // A recursive function to construct BST from pre[]. preIndex is used
	    // to keep track of index in pre[].
	    public TreeNode<Integer> constructTreeUtil(int pre[], Index preIndex, int key,
	            int min, int max, int size) {
	    	
	    	if(preIndex.preorderIndex >= pre.length)
	    	{
	    		return null;
	    	}
	    	
	    	TreeNode<Integer> root = null;
	    	
	    	if(key > min && key<max)
	    	{
	    		root = new TreeNode<Integer>(key);
	    		
	    		preIndex.preorderIndex++;
	    		
	    		if(preIndex.preorderIndex<pre.length)
	    		{
	    			root.left = constructTreeUtil(pre, preIndex, pre[preIndex.preorderIndex], min, key, size);
	    			root.right = constructTreeUtil(pre, preIndex, pre[preIndex.preorderIndex], key, max, size);
	    		}
	    	}
	    	
	    	return root;
	    }
	    
	    // The main function to construct BST from given preorder traversal.
	    // This function mainly uses constructTreeUtil()
	    TreeNode<Integer> constructTree(int pre[], int size) {

	        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE,
	                Integer.MAX_VALUE, size);
	    }
	 

	 
	    // Driver program to test above functions
	    public static void main(String[] args) {
	        ConstructFromPreOrder tree = new ConstructFromPreOrder();
	        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
	        int size = pre.length;
	        TreeNode<Integer> root = tree.constructTree(pre, size);
	        System.out.println("Inorder traversal of the constructed tree is ");
	        new Traversal<Integer>().inorder(root);
	    }
}
