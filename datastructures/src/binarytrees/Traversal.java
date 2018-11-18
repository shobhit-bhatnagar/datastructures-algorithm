package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

/**
 * This class will have all kind of possible traversal of a tree
 * @author shobhit
 * @param <T>
 *
 */
public class Traversal<T> {

	public void inorder(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public void preOrder(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	/*
	 * efficient O(n) and O(h) space
	 */
	public void levelOrderTraversal(TreeNode<T> root)
	{
		//use Queue
		
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode<T> n = queue.poll();
			
			System.out.println(n.data);
			
			if(n.left != null)
			{
				queue.add(n.left);
			}
			
			if(n.right != null)
			{
				queue.add(n.right);
			}
		}
	}
	
	public void levelOrderSpiral(TreeNode<T> root)
	{
		Stack<TreeNode<T>> s1 = new Stack<TreeNode<T>>();
		Stack<TreeNode<T>> s2 = new Stack<TreeNode<T>>();
		
		s1.add(root);
		
		while(!s1.isEmpty() || s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				TreeNode<T> n = s1.pop();
				
				System.out.println(n.data);
				
				if(n.right != null)
				{
					s2.add(n.right);
				}
				
				if(n.left != null)
				{
					s2.add(n.left);
				}
			}
			
			while(!s2.isEmpty())
			{
				TreeNode<T> n = s2.pop();
				
				System.out.println(n.data);
				
				if(n.left != null)
				{
					s1.add(n.left);
				}
				if(n.right != null)
				{
					s1.add(n.right);
				}
				
				
			}
		}
		
	}
	
	
	public void boundryTraversal(TreeNode<T> root)
	{
		if(root == null)
		{
			return;
		}
		
		System.out.println(root.data);
		printLeftBoundry(root.left);
		
		printLeaves(root.left);
		
		printLeaves(root.right);
		
		printRightBoundry(root.right);
	}

	/**
	 * @param node
	 */
	private void printRightBoundry(TreeNode<T> node) {
		
		if(node == null)
		{
			return;
		}
		
		if(node.right !=null)
		{
			printRightBoundry(node.right);
			System.out.println(node.data);		
		}
		else if(node.left !=null)
		{
			printRightBoundry(node.left);
			System.out.println(node.data);
		}
	}

	private void printLeaves(TreeNode<T> node) {
		
		if(node == null)
		{
			return;
		}
		
		printLeaves(node.left);
		if(node.left== null && node.right == null)
		{
			System.out.println(node.data);
		}
		printLeaves(node.right);
	}

	private void printLeftBoundry(TreeNode<T> node) {

		if(node == null)
		{
			return;
		}
		
		if(node.left != null)
		{
			System.out.println(node.data);
			printLeftBoundry(node.left);
		}
		else if(node.right != null)
		{
			System.out.print(node.data);
			printRightBoundry(node.right);	
		}
		
	}
	
	/**
	 * @param node
	 * @param m
	 * @param d
	 */
	public void diagonalTraversal(TreeNode<T> node , Map<Integer,List<T>> m, int d)
	{
		
		if(node == null)
		{
			return;
		}
		List<T> l = m.get(d);
		
		if(l == null)
		{
			l = new ArrayList<T>();
		}
		l.add(node.data);
		m.put(d, l);
		
		diagonalTraversal(node.left, m, d+1);
		
		diagonalTraversal(node.right, m, d);
	}
}
