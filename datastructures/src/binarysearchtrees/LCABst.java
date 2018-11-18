package binarysearchtrees;

import util.TreeNode;

public class LCABst {

	
	public int lca(TreeNode<Integer> root, TreeNode<Integer> s, TreeNode<Integer> b)
	{
		
		if(root == null)
		{
			return -1;
		}
		
		// get to a node in bound
		while(s.data > root.data || b.data < root.data)
		{
			while(s.data > root.data)
			{
				root = root.right;
			}
			
			while(b.data < root.data)
			{
				root = root.left;
			}
		}
		
		// s.data < root and b.data > root
		
		return root.data;
	}
}
