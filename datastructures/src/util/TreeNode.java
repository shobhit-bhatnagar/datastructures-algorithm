package util;

public class TreeNode<T> {

	public TreeNode<T> left;
	public TreeNode<T> right;
	public T data;
	
	public TreeNode(T data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
