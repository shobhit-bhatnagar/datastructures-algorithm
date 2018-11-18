package binarytrees;

public class PrintPostOrderFromGivenTraversal {

	static int preI = 0;
	
	
	/*
	 *  Reason we take preI as static because we need to increment it in every recursive call
	 *  we will not use same index for left child and right child
	 *  
	 */
	public static void  printPostOrder(int[]in,int pre[],int start,int end)
	{
		
		if (preI >= pre.length) {
			return;
		}
		if (start > end) {
			return;
		}
		int key = pre[preI];
		preI++;
		if (start < end) {
			int inIndex = search(in, key);
			printPostOrder(in, pre,start, inIndex - 1);

			printPostOrder(in, pre, inIndex + 1, end);
		}
		
		System.out.print(key);
	}

	private static int search(int[] in, int key) {
		
		
		for(int i = 0;i<in.length;i++)
		{
			if(in[i] == key )
			{
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] arg)
	{
		int[] in = new int[]{2,1,3};
		int [] pre = new int[]{1,2,3};
		printPostOrder(in, pre, 0, in.length);
	}
}
