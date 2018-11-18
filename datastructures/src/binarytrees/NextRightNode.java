package binarytrees;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class NextRightNode<T> {

	
    // Driver program to test above functions
    public static void main(String args[]) 
    {
        NextRightNode<Integer> tree = new NextRightNode<Integer>();
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(5);
        root.left.left = new TreeNode<Integer>(8);
        root.left.right = new TreeNode<Integer>(4);
  
        tree.test(root, 10);
        tree.test(root, 2);
        tree.test(root, 6);
        tree.test(root, 5);
        tree.test(root, 8);
        tree.test(root, 4);
  
    }
    
 // A utility function to test above functions
    void test(TreeNode<Integer> root, int k) 
    {
    	TreeNode<Integer> nr = nextRight(root, k);
        if (nr != null)
            System.out.println("Next Right of " + k + " is " + nr.data);
        else
            System.out.println("No next right node found for " + k);
    }

	private TreeNode<Integer> nextRight(TreeNode<Integer> root, int k) {
		
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		
		queue.add(root);
		TreeNode<Integer> marker = new TreeNode<Integer>(4);
		
		queue.add(marker);
		
		while(!queue.isEmpty())
		{
			TreeNode<Integer> n = queue.poll();
			
			if(n == marker)
			{
				if(queue.isEmpty())
				{
					return null;
				}
				queue.add(marker);
				continue;
			}
			
			if(n.data == k)
			{
				if(queue.isEmpty() || queue.peek() == marker)
				{
					return null;
				}
				else
				{
					return queue.peek();
				}
			}
			if(n.left != null)
			{
				queue.add(n.left);
			}
			if(n.right !=null)
			{
				queue.add(n.right);
			}
		}
		return null;
	}
}
