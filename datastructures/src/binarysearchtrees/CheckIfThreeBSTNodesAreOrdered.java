 package binarysearchtrees;

import util.TreeNode;

public class CheckIfThreeBSTNodesAreOrdered {

	
	public boolean pairIncludeAncAndDesc(TreeNode<Integer> node1, TreeNode<Integer> node2, TreeNode<Integer> middle)
	{
		while(node1!=node2 && node1!= middle  && node2!=middle &&(node1!=null||node2!=null))
		{
			if(node1!=null)
			{
				node1 = node1.data >middle.data ? node1.left:node1.right;
			}
			if(node2!=null)
			{
				node2 = node2.data > middle.data?node2.left:node2.right;
			}
		}
		
		if((node2!=middle && node1!=middle) || node1==node2)
		{
			return false;
		}
		
		return node1==middle?target(middle,node2) : target(middle,node1);
	}

	private boolean target(TreeNode<Integer> middle, TreeNode<Integer> node) {
		
		while(middle != null)
		{
			if(node.data > middle.data)
			{
				middle = middle.right;
			}
			else if(node.data < middle.data)
			{
				middle =middle.right;
			}
			else
			{
				return true;
			}
		}
		return false; 
	}
}
