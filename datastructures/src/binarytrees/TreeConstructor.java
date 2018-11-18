package binarytrees;

import util.TreeNode;

public class TreeConstructor {

	// driver program to test above functions
	int preIndex = 0;
    public static void main(String args[]) 
    {
    	TreeConstructor tree = new TreeConstructor();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        TreeNode<String> root = tree.buildTree(in, pre, 0, len - 1);
  
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        
        Traversal<String> t = new Traversal<String>();
        t.inorder(root);
        t.preOrder(root);
        
    }

	private TreeNode<String> buildTree(char[] in, char[] pre, int low, int high) {
		
		if(low>high)
		{
			return null;
		}
		TreeNode<String>node = new TreeNode<String>(pre[preIndex++]+"");
		
		if(low == high)
		{
			return node;
		}
		int InIndex = search(in, node.data,low,high);
		node.left = buildTree(in,pre,low,InIndex-1);
		node.right = buildTree(in,pre,InIndex+1,high);
		return node;
	}

	private int search(char[] in, String data, int low, int high) {
		
		int i;
        for (i = low; i <= high; i++) 
        {
            if ((in[i]+"").equalsIgnoreCase(data))
                return i;
        }
        return i;
	}
}
