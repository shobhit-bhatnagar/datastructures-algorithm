package strings;

public class Permutation {

	
	public void permute(String str,int l,int r)
	{
		if(l>=r)
		{
			System.out.println(str);
		}
		else
		{
			for(int i =l;i<=r;i++)
			{
				if(shouldSwap(str,l,i))
				{
					str = swap(str,l,i);
					permute(str,l+1,r);
					str = swap(str,l,i);
				}
			}
		}
	}

	private String swap(String str, int l, int i) {
		
		char[] chara = str.toCharArray();
		char temp = chara[l];
		chara[l]= chara[i];
		chara[i]= temp;
		
		return new String(chara);
	}
	
	private boolean shouldSwap(String str,int l,int r)
	{
		for(int i=l;i<r;i++)
		{
			if(str.charAt(i) == str.charAt(r))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		String str = "abcs";
		new Permutation().permute("abca", 0, str.length()-1);
	}
}
