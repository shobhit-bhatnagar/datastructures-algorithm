package binarytrees;

import util.TreeNode;

// this class is for finding max path between two leaves of binary tree.
public class MaximumPathSum<T> {

	
	   static class Res
	   {
		   int val = 0;
	   }
	  int maxPathSum( TreeNode<Integer> root)
	    {
	        Res res = new Res();
	        res.val = Integer.MIN_VALUE;
	        maxPathSumUtil(root, res);
	        return res.val;
	    }
	 
	    private int maxPathSumUtil(TreeNode<Integer> root, Res res) 
	    {
	    	if(root == null)
	    	{
	    		return 0;
	    	}
	    	if(root.left == null && root.right == null)
	    	{
	    		return root.data;
	    	}
	    	int leftpath = maxPathSumUtil(root.left, res);
	    	int rightPath = maxPathSumUtil(root.right, res);
	    	
	    	if(root.left != null && root.right != null)
	    	{
	    		res.val = Math.max(res.val, leftpath+rightPath + root.data);
	    		
	    		return root.data + (leftpath>rightPath?leftpath:rightPath);
	    	}
	    	
	    	return root.left==null?  root.data+rightPath:  root.data+leftpath;
		
	    }

		//Driver program to test above functions
	    public static void main(String args[]) {
	    	MaximumPathSum<Integer> tree = new MaximumPathSum<Integer>();
	    	TreeNode<Integer> root = new TreeNode<Integer>(-15);
	        root.left = new TreeNode<Integer>(5);
	        root.right = new TreeNode<Integer>(6);
	        root.left.left = new TreeNode<Integer>(-8);
	        root.left.right = new TreeNode<Integer>(1);
	        root.left.left.left = new TreeNode<Integer>(2);
	        root.left.left.right = new TreeNode<Integer>(6);
	        root.right.left = new TreeNode<Integer>(3);
	        root.right.right = new TreeNode<Integer>(9);
	        root.right.right.right = new TreeNode<Integer>(0);
	        root.right.right.right.left = new TreeNode<Integer>(4);
	        root.right.right.right.right = new TreeNode<Integer>(-1);
	        root.right.right.right.right.left = new TreeNode<Integer>(10);
	        System.out.println("Max pathSum of the given binary tree is "
	                + tree.maxPathSum(root));
	    }
}
