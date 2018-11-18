package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Reorder an array sduch that equal elements comes together
 * 
 * Array of student with name and age
 * students with equal age should come together..
 * @author shobhit
 *
 */
public class PartitioningWithRepeatedEntries {

	
	/**
	 * 
	 * ALgorithm
	 * 
	 * Two hashmaps
	 * one for age to count other for age to offset
	 */
	
	static class Person
	{
		String name;
		int age;
		public Person(String name,int age)
		{
			this.name = name;
			this.age = age;
		}
		public String toString()
		{
			return "[" + this.name+","+this.age+"]";
		}
	}
	public static void groupByAge(List<Person> list)
	{
		
		Map<Integer,Integer> ageToCount = new HashMap<Integer,Integer>();
		
		LinkedHashMap<Integer,Integer> ageToOffset = new LinkedHashMap<Integer,Integer>();
		
		
		for(Person p:list)
		{
			
			if(ageToCount.get(p.age) == null)
			{
				ageToCount.put(p.age, 0);
			}
			
			ageToCount.put(p.age, ageToCount.get(p.age) +1);
		}
		
		
		// update ageToOffset for each entry in hashmap age to Count
		
		Iterator<Entry<Integer,Integer>> itr = ageToCount.entrySet().iterator();
		int offSet = 0;
		while(itr.hasNext())
		{
			Entry<Integer,Integer> ageCountPair = itr.next();
			ageToOffset.put(ageCountPair.getKey(),offSet);
			offSet+=ageCountPair.getValue();
			
		}
		while(ageToOffset.size() != 0)
		{
			Iterator<Entry<Integer,Integer>> itrator = ageToOffset.entrySet().iterator();
			
			Entry<Integer,Integer> from = itrator.next();
			int index = from.getValue();
			int tempAge = 		list.get(index).age;
			int offSetOfAge = ageToOffset.get(tempAge);
			
			swap(list, index,offSetOfAge);
			ageToCount.put(tempAge, ageToCount.get(tempAge)-1);
			if(ageToCount.get(tempAge) > 0)
			{
				// increment offset for next value
				ageToOffset.put(tempAge, offSetOfAge+1);
			}
			else
			{
				ageToOffset.remove(tempAge);
			}
		}
	}
	private static void swap(List<Person> list, int index, int indexOther) {
		
		Person temp = list.get(index);
		Person temp2 = list.get(indexOther);
		list.remove(index);
		list.add(index, temp2);
		list.remove(indexOther);
		list.add(indexOther,temp);
		
	} 
	
	public static void main(String []str)
	{
		List<Person> l = new ArrayList<Person>();
		Person p = new Person("Greg",14);
		l.add(p);
		p = new Person("John",12);
		l.add(p);
		p = new Person("Andy",11);
		l.add(p);
		p = new Person("Jim",13);
		l.add(p);
		p = new Person("Phil",12);
		l.add(p);
		p = new Person("Bob",13);
		l.add(p);
		p = new Person("Chip",13);
		l.add(p);
		p = new Person("Tim",14);
		l.add(p);
		groupByAge(l);
		System.out.println(l.toString());
	}
}
