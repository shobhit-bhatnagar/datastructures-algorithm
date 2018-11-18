package binarytrees;

import util.TreeNode;

public class DeepestLeftLeafNode<T> {

	
	TreeNode<Integer> result = null;
	
	 // Driver program to test above functions
    public static void main(String[] args) 
    {
    	DeepestLeftLeafNode<Integer> tree = new DeepestLeftLeafNode<Integer>();
       TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);
        root.right.left.right = new TreeNode<Integer>(7);
        root.right.right.right = new TreeNode<Integer>(8);
        root.right.left.right.left = new TreeNode<Integer>(9);
        root.right.right.right.right = new TreeNode<Integer>(10);
 
        tree.deepestLeftLeaf(root);
        if (tree.result != null)
            System.out.println("The deepest left child"+
                               " is " + tree.result.data);
        else
            System.out.println("There is no left leaf in"+
                               " the given tree");
    }

   static class Level
    {
    	public int l = 0;
    }
	private void deepestLeftLeaf(TreeNode<Integer> root) {
			
		Level level = new Level();
		
		deepestLeftLeafUtil(root,false,0,level);
		
	}
	private void deepestLeftLeafUtil(TreeNode<Integer> root, boolean isLeft, int currentLevel, Level maxLevel) {


		if(root ==null)
		{
			return;
		}
		
		if(isLeft && root.left==null && root.right ==null && currentLevel > maxLevel.l)
		{
			result = root;
			maxLevel.l = currentLevel;
		}
			
		deepestLeftLeafUtil(root.left, true, currentLevel+1, maxLevel);
		deepestLeftLeafUtil(root.right, false, currentLevel+1, maxLevel);
	}
}
