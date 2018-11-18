package binarysearchtrees;

import util.TreeNode;

public class DeleteNode {

	
	public void delete(TreeNode<Integer> node, TreeNode<Integer> n)
	{
		delete(node,n.data);
	}

	private TreeNode<Integer> delete(TreeNode<Integer> node, Integer data) {
		
		if(node == null)
		{
			return node;
		}
		
		if(node.data<data)
		{
			node.right = delete(node.right, data);
		}
		else if(node.data>data)
		{
			node.left = delete(node.left, data);
		}
		else
		{
			if(node.left == null)
			{
				return node.right;
			}
			else if(node.right == null)
			{
				return node.left;
			}
			
			node.data = min(node.right);
			
			node.right = delete(node.right, node.data);
		}
		
		return node;
		
	}

	private Integer min(TreeNode<Integer> right) {
		
		while(right.left != null)
		{
			right = right.left;
		}
		return right.data;
	}
}
