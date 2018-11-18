package binarysearchtrees;

import util.TreeNode;

public class FirstOccurenceOfKey {

	
	public TreeNode<Integer> firstOccurence(TreeNode<Integer> root,int key)
	{
		
		if(root == null)
		{
			return null;
		}
		TreeNode<Integer> firstSoFar = null;
		while(root != null)
		{
			if(key < root.data)
			{
				root = root.left;
			}
			else if(key > root.data)
			{
				root = root.right;
			}
			else
			{
				firstSoFar = root;
				root = root.left;
			}
		}
		
		return firstSoFar;
	}
}
