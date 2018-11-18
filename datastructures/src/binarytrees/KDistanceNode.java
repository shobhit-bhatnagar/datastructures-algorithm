package binarytrees;

import util.TreeNode;

public class KDistanceNode {

	
	public void printKNodeDown(TreeNode<Integer> root, int k)
	{
		if(root == null || k < 0)
		{
			return;
		}
		if(k == 0)
		{
			System.out.println(root.data+" ");
		}
		
		printKNodeDown(root.left, k-1);
		printKNodeDown(root.right, k-1);
	}
	
	public int printKDistanceNode(TreeNode<Integer> root, TreeNode<Integer> target, int k)
	{
		if(root == null)
		{
			return -1;
		}
		
		/*
		 * if target node found then print nodes k distance in descendants
		 */
		if(root == target)
		{
			printKNodeDown(root, k);
			return 1;
		}
		
		/*
		 * find node in left subtree
		 */
		int dl = printKDistanceNode(root.left, target, k);
		// if node found in left subtree
		if(dl!=-1)
		{
			/*
			 * it means root is k distance away
			 */
			if(dl==k)
			{
				System.out.println(root.data+" ");
			}
			else
			{
				// go downward to right subtree from ancestor at distance k-d-2
				// since i have travelled dl distance upward + root + root .right so distance left k-dl-2
				
				printKNodeDown(root.right, k-dl-1);
			}
			return dl+1;
		}
		
		// if node found in right subtree use mirror of above code;
		
		int dr = printKDistanceNode(root.right, target, k);
		
		if(dr != -1)
		{
			if(dr==k)
			{
				System.out.println(root.data+" ");
			}
			else
			{
				printKNodeDown(root.left, k-dr-1);
			}
			return dr+1;
		}
		
		return -1;
	}
	
	 // Driver program to test the above functions
    public static void main(String args[]) 
    {
        KDistanceNode tree = new KDistanceNode();
  
        /* Let us construct the tree shown in above diagram */
        TreeNode<Integer> root = new TreeNode<Integer>(20);
        root.left = new TreeNode<Integer>(8);
        root.right = new TreeNode<Integer>(22);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(12);
        root.left.right.left = new TreeNode<Integer>(10);
        root.left.right.right = new TreeNode<Integer>(14);
        TreeNode<Integer> target = root.left.right;
        tree.printKDistanceNode(root, target, 2);
        
        tree.printKDistanceNode(root, root.left.left, 3);
    }
}
