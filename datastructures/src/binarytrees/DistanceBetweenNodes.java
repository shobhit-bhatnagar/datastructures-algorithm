package binarytrees;

import util.TreeNode;

public class DistanceBetweenNodes<T> {

	static int d1 = -1;
	static int d2= -1;
	static int distance =0;
	
	/*
	 * keep track of level of each TreeNode<Integer> 
	 */
	
	public static void main(String[] args) {
        
        // Let us create binary tree given in the above example
        TreeNode<Integer>  root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        root.right.left.right = new TreeNode<Integer>(8);
        
        System.out.println("Dist(4, 5) = "+findDistance(root, 4, 5));
        System.out.println("Dist(4, 6) = "+findDistance(root, 4, 6));
        System.out.println("Dist(3, 4) = "+findDistance(root, 3, 4));
        System.out.println("Dist(2, 4) = "+findDistance(root, 2, 4));
        System.out.println("Dist(8, 5) = " +findDistance(root, 8, 5));
         
    }

	private static int findDistance(TreeNode<Integer> root, int n1, int n2) {
		
		if(root == null)
		{
			return 0;
		}
		TreeNode<Integer>lca = findDistanceUtil(root,n1,n2,1);
		if(d1!=-1 && d2 != -1)
		{
			return distance;
		}
		if(d2 == -1)
		{
			// here lca is n1
			distance = findLevel(lca,n2,0);
		}
		else if(d1 == -1)
		{
			// here lca is n2
			distance = findLevel(lca,n1,0);
		}
		return distance;
		
	}

	private static int findLevel(TreeNode<Integer> lca, int n2, int lvl) {

		if(lca == null)
		{
			return -1;
		}
		
		if(lca.data == n2)
		{
			return lvl;
		}
		int l1 = findLevel(lca.left,n2, lvl+1);
		
		return l1 == -1?findLevel(lca.right,n2,lvl +1):l1;
	}

	private static TreeNode<Integer> findDistanceUtil(TreeNode<Integer> root, int n1, int n2, int lvl) {


		if(root == null)
		{
			return null;
		}
		
		if(root.data == n1)
		{
			d1 = lvl;
			return root;
		}
		
		if(root.data == n2)
		{
			d2 = lvl;
			return root;
		}
		
		TreeNode<Integer> left = findDistanceUtil(root.left, n1, n2, lvl+1);
		
		TreeNode<Integer> right = findDistanceUtil(root.right, n1, n2, lvl+1);
		
		if(left != null && right !=null)
		{
			distance = d1+d2 - (2*lvl);
			
			return root;
		}
		
		return left == null?right:left;
	}
}
