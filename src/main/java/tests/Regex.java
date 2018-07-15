package tests;

public class Regex {

	public static void main(String[] args) {

		String statement = "Hel$lo wor123ld %$asd 123";

		String patternAlphabets = "[a-zA-Z]";
		String patternNumbers = "\\d";
		String patternSpecialCharacters = "\\W";

		System.out.println("Only Numbers " +statement.replaceAll(patternAlphabets, "").replaceAll(patternSpecialCharacters, ""));
		System.out.println("Only Alphabets " +statement.replaceAll(patternNumbers, "").replaceAll(patternSpecialCharacters, ""));
		System.out.println("Only Special Characters " +statement.replaceAll(patternNumbers, "").replaceAll(patternAlphabets, ""));
		
		
	char[] charArray = statement.toCharArray();
		int length = statement.length();
		int count =0;
		for(int i = 1; i<=length;i++)
		{
			if(charArray[i]==' ')
			{
				count++;
				if(count>2)
				{
//					charArray[i]='';
				}
			}
		}
		
		
		
		
		
		
		
		
		
	}

}
