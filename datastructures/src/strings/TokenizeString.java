package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TokenizeString {

	
	public static void main(String[] arf) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int first=0;
		List<String> l = new ArrayList<>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == ' ')
			{
				l.add(str.substring(first, i));
				first = i+1;
			}
			if(str.charAt(i) == '\"')
			{
				String temp = str.substring(i+1, str.length());
				int tempIndex = i+temp.indexOf('\"');
				if(tempIndex!=-1)
				{
				temp = str.substring(i, tempIndex+2);
				l.add(temp);
				i=tempIndex+4;
				first = tempIndex+3;
				}
			}
		}
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i));
		}
		
	}
}
