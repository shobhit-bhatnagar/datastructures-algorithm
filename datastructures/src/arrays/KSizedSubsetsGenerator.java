package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KSizedSubsetsGenerator {

	List<List<Integer>> listOfKSizedArrays = new ArrayList<List<Integer>>();
	
	Set<Integer> uniqueSum = new HashSet<Integer>();
	public void generateKSets(int[] arr,int n,Integer [] data,int k,int index,int i)
	{
		
		if(index==k)
		{
			addToList(data);
			return;
		}
		// if whole array has been traversed 
		if(i>=n)
		{
			return;
		}
		
		// include ith element and recur to find k-1 size sets in array(i+1,n)
		data[index] = arr[i];
		
		generateKSets(arr, n, data, k, index+1, i+1);
		
		//exclude ith element and recur to find k subsets in arr i+1 to n
		
		generateKSets(arr, n, data, k, index, i+1);
	}
	
	private void addToList(Integer[] data) {

		List<Integer> list = new ArrayList<Integer>();
		
		int sum=0;
		for(int i =0;i<data.length;i++)
		{
			list.add(data[i]);
			sum+=data[i];
		}
		
		uniqueSum.add(sum);
		
		this.listOfKSizedArrays.add(list);
		
	}

	public static void main(String[] args)
	{
		int [] arr = {1,2,3,4,5};
		
		int k =2;
		Integer [] data = new Integer[k];
		KSizedSubsetsGenerator generator = new KSizedSubsetsGenerator();
		generator.generateKSets(arr, arr.length, data, k, 0, 0);
		
		for(List<Integer>list:generator.listOfKSizedArrays)
		{
			System.out.println(list.toString());
		}
		
		System.out.println(generator.uniqueSum.toString());
	}
}
