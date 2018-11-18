package binarytrees;

import util.TreeNode;

public class InOrderSuccessor {

	public TreeNode<Integer> inOrderSucc(TreeNode<Integer> root, TreeNode<Integer> node)
	{
		if(node == null)
		{
			return null;
		}
		if(node.right != null)
		{
			return leftMost(node.right);
		}
		if(node.right == null)
		{
			TreeNode<Integer> rightMost = rightMost(root);
			if(node == rightMost)
			{
				return null;
			}
		}
		
		return inOrderSuccesor(root,node);
	}

	private TreeNode<Integer> inOrderSuccesor(TreeNode<Integer> root, TreeNode<Integer> node) {
		
		if(root == null)
		{
			return null;
		}
		TreeNode<Integer> temp = null;
		if(root == node || (temp = inOrderSuccesor(root.left, node)) != null || (temp = inOrderSuccesor(root.right, node)) != null)
		{
			if(temp != null)
			{
				if(root.left == temp)
				{
					System.out.println(" Successor is "+ root.data);
					return null;
				}
			}
			return root;
		}
		return null;
	}

	private TreeNode<Integer> rightMost(TreeNode<Integer> root) {
		
		while(root.right != null)
		{
			root = root.right;
		}
		return root;
	}

	private TreeNode<Integer> leftMost(TreeNode<Integer> node) {
		
		while(node.left != null)
		{
			node = node.left;
		}
		return node;
	}
	
	public static void main(String[] args)
	{
		InOrderSuccessor bc = new InOrderSuccessor();
		
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        root.left.left.left = new TreeNode<Integer>(8);

        bc.inOrderSucc(root, root.left.right);
		
	}
}
