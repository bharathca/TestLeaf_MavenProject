package tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import javax.print.DocFlavor.CHAR_ARRAY;

public class StringReverse {

	public static void main(String[] args) {


		/*char[] charArray = name.toCharArray();

		for(int i = name.length()-1;i>=0;i--)
		{
			System.out.print(charArray[i]);
		}
		System.out.println();
		for(int i = name.length()-1;i>=0;i--)
		{
			System.out.print(name.charAt(i));
		}
		System.out.println();
		StringBuilder builder = new StringBuilder(name);

		System.out.println(builder.reverse());*/


		/*Set<Character> uniqueName = new HashSet<Character>();
		for (Character character : charArray) {
			uniqueName.add(character);
		}
		System.out.println(uniqueName);




		List<Character> uniqueNameList = new ArrayList<Character>();
		for (Character character : charArray) {
			if(!(uniqueNameList.contains(character)))
			{
				uniqueNameList.add(character);
			}
		}
		System.out.println(uniqueNameList);
		 */




		String name ="basbs";
		char[] charArray = name.toCharArray();
		int count = 0;
		String input1 = "12345";
		String input2 = "123456";
		String input3 = "123.56";

		System.out.println(Pattern.matches("[0-9]{5}", input1));




		System.out.println("Enter string to reverse:");

		Scanner read = new Scanner(System.in);
		String str = read.nextLine();
		String reverse = "";


		for(int i = str.length() - 1; i >= 0; i--)
		{
			reverse = reverse + str.charAt(i);
		}

		System.out.println("Reversed string is:");
		System.out.println(reverse);


	}

}
