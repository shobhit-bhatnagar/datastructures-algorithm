package binarytrees;

import util.TreeNode;

public class BalanceBTreeCheck<T> {

	
	static class Pair
	{
		public boolean isBalanced = false;
		public int height = -1;
		public Pair(boolean b, int i) {
			this.isBalanced = b;
			this.height = i;
		}

	}
	
	public static void main(String[] args)
	{
		BalanceBTreeCheck<Integer> bc = new BalanceBTreeCheck<Integer>();
		
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        root.left.left.left = new TreeNode<Integer>(8);
        root.left.left.right = new TreeNode<Integer>(9);
        root.left.left.left.left = new TreeNode<Integer>(8);
        root.left.left.left.left.left = new TreeNode<Integer>(8);
        
        
        System.out.println(bc.isBalanced(root).isBalanced);
		
	}

	private Pair isBalanced(TreeNode<Integer> root) {
		
		if(null == root)
		{
			return new Pair(true,-1);
		}
		
		Pair leftSubTree = isBalanced(root.left);
		
		if(!leftSubTree.isBalanced)
		{
			return leftSubTree;
		}
		
		Pair rightSubTree = isBalanced(root.right);
		
		if(!rightSubTree.isBalanced)
		{
			return rightSubTree;
		}
		
		boolean isBalanced = Math.abs(leftSubTree.height-rightSubTree.height) <=1;
		
		int height = Math.max(leftSubTree.height, rightSubTree.height)+1;
		
		return new Pair(isBalanced,height);
	}
}
