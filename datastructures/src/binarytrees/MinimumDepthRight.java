package binarytrees;

import util.TreeNode;

public class MinimumDepthRight {

	static class MinLevel
	{
		int l = Integer.MAX_VALUE;
	}
	/**
	 * 
	 * @param node
	 * @param isRight
	 * @param level
	 * @param currentLevel
	 *      				1
	 *      		2				3
	 *      	4		 5		6		7				---- Min Right Depth = 2
	 *        8    9  10
	 */
	public void minDepth(TreeNode<Integer> node,boolean isRight, MinLevel level,int currentLevel)
	{
		if(node==null)
		{
			return ;
		}
		if(isRight && node.left==null && node.right==null && currentLevel <level.l)
		{
			level.l=currentLevel;
			
		}
		minDepth(node.left,false,level,currentLevel+1);
		minDepth(node.right,true,level,currentLevel+1);
		
		
	}
	
	public int minDepth(TreeNode<Integer> node)
	{
		if(node == null)
		{
			return 0;
		}
		if(node.left==null && node.right==null)
		{
			return 0;
		}
		
		return 1+Integer.min(minDepth(node.left), minDepth(node.right));
	}
	
	 public static void main(String[] args) 
	    {
	    	MinimumDepthRight tree = new MinimumDepthRight();
	       TreeNode<Integer> root = new TreeNode<Integer>(1);
	        root.left = new TreeNode<Integer>(2);
	        root.right = new TreeNode<Integer>(3);
	        root.left.left = new TreeNode<Integer>(4);
	        root.left.left.left = new TreeNode<Integer>(8);
	        root.left.left.right = new TreeNode<Integer>(9);
	        root.left.right= new TreeNode<Integer>(5);
	        root.left.right.left= new TreeNode<Integer>(10);
	        root.right.left = new TreeNode<Integer>(6);
	        root.right.right = new TreeNode<Integer>(7);

	        MinLevel l = new MinLevel();
	        tree.minDepth(root, false,l, 0);
	        
	        System.out.println(l.l);
	        System.out.println(tree.minDepth(root));
	        
	        
	        root =  new TreeNode<Integer>(1);
	        root.left = new TreeNode<Integer>(2);
	        root.left.right = new TreeNode<Integer>(3);
	        
	        root.right= new TreeNode<Integer>(4);
	        root.right.right = new  TreeNode<Integer>(5);
	        root.right.right.right = new TreeNode<Integer>(6);
	        
	        l = new MinLevel();
	        tree.minDepth(root,false,l,0);
	        
	    }
}
