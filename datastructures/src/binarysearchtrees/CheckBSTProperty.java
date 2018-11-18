package binarysearchtrees;
import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;
public class CheckBSTProperty {

	
	static class QueueEntry
	{
		TreeNode<Integer> node;
		int lower,upper;
		QueueEntry(TreeNode<Integer> node,int lower,int upper)
		{
			this.node = node;
			this.lower = lower;
			this.upper = upper;
		}
	}
	
	public boolean isBST(TreeNode<Integer> root)
	{
		Queue<QueueEntry> q = new LinkedList<QueueEntry>();
		
		q.offer(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		
		while(!q.isEmpty())
		{
			QueueEntry qe = q.peek();
			if(qe.node != null)
			{
				if(qe.node.data < qe.lower || qe.node.data > qe.upper)
				{
					return false;
				}
				q.offer(new QueueEntry(qe.node.left, qe.lower, qe.node.data));
				q.offer(new QueueEntry(qe.node.right, qe.node.data, qe.upper));
			}
			q.poll();
		}
		
		return true;
	}
}
