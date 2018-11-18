package binarytrees;

import util.TreeNode;

/**
 * Given a binary tree, print out all of its root-to-leaf paths one per line.
 * 
 * @author shobhit
 *
 *
 *
 */
/*
 * Algorithm:
 * 
 * initialize: pathlen = 0, path[1000] 1000 is some max limit for paths, it can
 * change
 * 
 * printPathsRecur traverses nodes of tree in preorder 
 * printPathsRecur(tree,
 * path[], pathlen) 1)
 *  If node is not NULL then 
 *  a) push data to path array:
 * path[pathlen] = node->data.
 * 
 *  b) increment pathlen pathlen++ 
 *  
 *  2) If node is a
 * leaf node then 
 * prit the path array. 3) 
 * Else 
 * a) Call printPathsRecur for left
 * subtree printPathsRecur(node->left, path, pathLen) 
 * b) Call printPathsRecur
 * for right subtree. printPathsRecur(node->right, path, pathLen)
 */

public class RootToLeafPath {

	/* Driver program to test all above functions */
	public static void main(String[] args) {
		RootToLeafPath tree = new RootToLeafPath();

		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);
		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(5);
		Traversal<Integer> t = new Traversal<>();
		
		t.inorder(root);
		/* Print all root-to-leaf paths of the input tree */
		tree.printPaths(root);

	}

	private void printPaths(TreeNode<Integer> root) {

		int[] pathArray = new int[1000];
		printPathRecur(root, pathArray, 0);
	}

	private void printPathRecur(TreeNode<Integer> root, int[] pathArray, int pathLen) {
		
		if(root == null)
		{
			return;
		}
		if(root != null)
		{
			pathArray[pathLen] = root.data;
			pathLen++;
		}
		
		if(root.left == null && root.right ==null)
		{
			printArray(pathArray,pathLen);
		}
		else
		{
			printPathRecur(root.left, pathArray, pathLen);
			printPathRecur(root.right, pathArray, pathLen);
		}
		

	}

	private void printArray(int[] pathArray, int pathLen) {


		for(int i=0;i<pathLen;i++)
		{
			System.out.print(pathArray[i]+" ");
		}
		System.out.println("");
	}
}
