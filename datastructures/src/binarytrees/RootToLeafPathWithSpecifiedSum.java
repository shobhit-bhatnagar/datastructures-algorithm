package binarytrees;

import util.TreeNode;

public class RootToLeafPathWithSpecifiedSum{

	
	public static void main(String[] args)
	{
		RootToLeafPathWithSpecifiedSum rt = new RootToLeafPathWithSpecifiedSum();
		
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        root.left.left.left = new TreeNode<Integer>(8);
        
        root.left.left.right = new TreeNode<Integer>(9);
        
        System.out.println(rt.isPathExist(root,12,0));
        
	}

	private boolean isPathExist(TreeNode<Integer> root, int targetSum,int currentSum) {
			
		if(root == null)
		{
			return false;
		}
		currentSum+=root.data;
		if(root.left == null && root.right == null)
		{
			if(currentSum == targetSum)
			{
				return true;
			}
		}
		
		return isPathExist(root.left, targetSum, currentSum) || isPathExist(root.right, targetSum, currentSum);
	}
}
