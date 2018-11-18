package dynamicprogramming;

public class MaxSizeSquareMatrixWithOnes {

	static void printMaxSubSquare(int M[][])
	{
		int rows = M.length;
		int cols = M[0].length;
		
		int [][]S= new int[rows][cols];
		
		for(int i =0;i<rows;i++)
		{
			S[i][0]=M[i][0];
		}
		
		for(int i =0;i<cols;i++)
		{
			S[0][i]=M[0][i];
		}
		
		for(int i =1;i<rows;i++)
		{
			for(int j=1;j<cols;j++)
			{
				if(M[i][j]==1)
				{
					S[i][j]= Integer.min(Integer.min(S[i-1][j], S[i][j-1]), S[i-1][j-1])+1;
				}
				else
				{
					S[i][j]=0;
				}
			}
		}
		int maxSize = S[0][0];
		int maxIndexRow=0;
		int maxIndexCol=0;
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(maxSize<S[i][j])
				{
					maxSize=S[i][j];
					maxIndexRow=i;
					maxIndexCol=j;
				}
			}
		}
		
		for(int row=maxIndexRow;row>maxIndexRow-maxSize;row--)
		{
			for(int col=maxIndexCol;col>maxIndexCol-maxSize;col--)
			{
				System.out.print(M[row][col]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
    {
        int M[][] =  {{0, 1, 1, 0, 1}, 
                      {1, 1, 0, 1, 0}, 
                      {0, 1, 1, 1, 0},
                      {1, 1, 1, 1, 0},
                      {1, 1, 1, 1, 1},
                      {0, 0, 0, 0, 0}};
              
        printMaxSubSquare(M);
    }
}
