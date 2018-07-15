package tests;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCount {

	public static void main(String[] args) {
		String companyName = "Infosys";
		companyName =companyName.toLowerCase();
		System.out.println("Lowercase"+companyName);
		char[] charArray = companyName.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (char eachChar : charArray) {
			System.out.println(eachChar);

			if(map.containsKey(eachChar))
			{
				map.put(eachChar, (map.get(eachChar)+1));
				
			}
			else
			{
				map.put(eachChar, 1);
			}
		}
		
		System.out.println(map.size());
		
		//compare two items and travel to next value and if the value is big then replace it with the value of tall
				
		System.out.println(map.entrySet());
	}

}
