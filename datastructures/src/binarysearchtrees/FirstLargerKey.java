package binarysearchtrees;

import util.TreeNode;

public class FirstLargerKey 
{

	public TreeNode<Integer> firstLarger(TreeNode<Integer> node, int key)
	{
		if(node == null)
		{
			return node;
		}
		TreeNode<Integer> firstLarger = null;
		while(node != null)
		{
			if(node.data > key)
			{
				firstLarger = node;
				node = node.left;
			}
			else
			{
				node = node.right;
			}
		}
		return firstLarger;
	}
}
