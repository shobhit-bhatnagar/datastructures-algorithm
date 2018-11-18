package binarytrees;

import util.TreeNode;

public class LowestCommonAncestor<T> {
	
	boolean v1= false;
	boolean v2= false;
	
	/* Driver program to test above functions */
    public static void main(String args[])
    {
    	LowestCommonAncestor<Integer> tree = new LowestCommonAncestor<Integer>();
        TreeNode<Integer>root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        TreeNode<Integer>lca = tree.findLCA(root,4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");
 
        tree.v1= false;
        tree.v2 = false;
        lca = tree.findLCA(root,3,8);
        if (lca != null)
            System.out.println("LCA(3, 7) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }

	private TreeNode<Integer> findLCA(TreeNode<Integer> root, int n1, int n2) {
		
		if(root == null)
		{
			return null;
		}
		
		TreeNode<Integer> lca = findLCAUtil(root,n1,n2);
		if(v1 && v2)
		{
			return lca;
		}
		return null;
	}

	private TreeNode<Integer> findLCAUtil(TreeNode<Integer> root, int n1, int n2) {
		
		
		if(root == null)
		{
			return null;
		}
		TreeNode<Integer> temp = null;
		if(root.data == n1)
		{
			v1 = true;
			temp = root;
		}
		
		if(root.data == n2)
		{
			v2 = true;
			temp = root;
		}
		
		TreeNode<Integer> leftLCA = findLCAUtil(root.left, n1, n2);
		
		TreeNode<Integer> rightLCA = findLCAUtil(root.right, n1, n2);
		
		if(temp != null)
		{
			return temp;
		}
		if(leftLCA != null && rightLCA != null)
		{
			return root;
		}
				
		return leftLCA!=null?leftLCA:rightLCA;
	}

}
