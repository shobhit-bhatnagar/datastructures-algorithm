package binarysearchtrees;

import java.util.List;

import util.TreeNode;

public class KLargestElement {

	
	public void kLargest(TreeNode<Integer> node,List<Integer> list,int k)
	{
		if(node != null && list.size()<k)
		{
			kLargest(node.right, list, k);
			
			if(list.size()<k)
			{
				list.add(node.data);
				kLargest(node.left, list, k);
			}
		}
	}
}
