package strings;

import java.util.Arrays;
import java.util.Comparator;

/*
 * given sequence of string print all anagram together
 */
public class PrintAnagramsTogerher {

	
	 static class Word
	{
		String str;
		int index;
		public Word(String str,int index)
		{
			this.str = str;
			this.index = index;
		}
		
		
	}
	 
	 static class DupWordArray
	 {
		 Word[] wordArray;
		 int size;
		 
		 public DupWordArray(String []str,int size)
		 {
			 this.size = size;
			 wordArray = new Word[size];
			 
			 for(int i = 0;i<size;i++)
			 {
				 wordArray[i] = new Word(str[i],i);
			 }
		 }
	 }
	 
	 static class ComparatorWord implements Comparator<Word>
	 {

		@Override
		public int compare(Word w1, Word w2) {
			return w1.str.compareTo(w2.str);
		}
		 
	 }
	 
	 
	 public void printAnagramsTogether(String[] wordArray,int size)
	 {
		 DupWordArray duplicateArray = new DupWordArray(wordArray, size);
		 
		 for(int i =0;i<size;i++)
		 {
			 char[] charArray = duplicateArray.wordArray[i].str.toCharArray();
			 
			 Arrays.sort(charArray);
			 
			 duplicateArray.wordArray[i].str = new String(charArray);
		 }
		 
		 Arrays.sort(duplicateArray.wordArray,new ComparatorWord());
		 
		 
		 for(int i = 0;i<size;i++)
		 {
			 System.out.print(wordArray[duplicateArray.wordArray[i].index] + " ");
		 }
	 }
	 
	 // Driver program to test above functions
	    public static void main(String args[])
	    {
	        String wordArr[] = {"cat", "dog", "tac", "god", "act"};
	        int size = wordArr.length;
	       new PrintAnagramsTogerher().printAnagramsTogether(wordArr, size);
	    }
}
