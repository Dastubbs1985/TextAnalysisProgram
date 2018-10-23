//Imports all required imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
public class AssignmentTextAnalyzer 
{
	//Declaration and initialization of the static variables
	static char st_inArrChar [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static double st_totalChar = 0;
	static String st_stringForAnalysis = "";
	static int st_vowel = 0;
	static int st_consonant = 0;
	static int st_puncCount = 0;
	static int st_numberCount = 0;
	static int st_wordCount = 0;
	static DecimalFormat df = new DecimalFormat("#.##"); 
	static DecimalFormat df2 = new DecimalFormat("#");
	public static String padding(String pu_inStr, double mostFreq)
	{
		//Pads out the bar to align all the numbers and frequency to the right of the bar chart
		String pu_outStr = pu_inStr;
		String pu_space = " ";
		while (pu_outStr.length() < mostFreq+2)
		{
			pu_outStr = pu_outStr + pu_space;
		}
		return pu_outStr;
	}
	public static String bar(char pu_x, double charFreqStr) 
	{
		//Creates a bar for the bar chart
		String str = Character.toString(pu_x);
		String pad = "|";
		while (str.length() < charFreqStr+1)
		{
			str = str + pad; 
		}
		return str;
	}
	public static int wordCount(String [] words)
	{
		//Calculates the total number of words
		int wordCount = 0;
		for (int x = 0; x < words.length; x++)
		if ((words[x] == null)||(words[x] == null))
		{
			continue;
		}
		else
		{
			wordCount++;
		}
		return wordCount;
	}
	public static int numbers(char [] n)	
	{
		//Calculates the total number of numbers in the string or file
		int pr_numbCount = 0;
		char numbers [] = {'0','1','2','3','4','5','6','7','8','9'};
		for (int i = 0; i < numbers.length; i++)
		{
			for (int d = 0; d < n.length; d++)
			{	
				if (n[d] == numbers[i])
				{
					pr_numbCount++;
				}else
				{
					continue;
				}
			}
		}
		return pr_numbCount;
	}
	public static int punctuation(char [] a)
	{
		//Calculates the total number of punctuation marks in the string or file
		int pr_punctuationCount = 0;
		char punctuations[] = {'¬','`','!','"','£','$','%','^','&','*','(',')','_','+','=','-',
								'{','}','[',']','@','~','\'','#','/','.',',','?','>','<','\\','|',';',':',' ' };
		for (int i = 0; i < punctuations.length; i++)
		{
			for (int c  = 0; c < a.length; c++)
			{
				if (a[c] == punctuations[i])
				{
					pr_punctuationCount++;
				}else
				{
					continue;
				}
			}
		}
		return pr_punctuationCount;
	}
	public static boolean Vowel(char x) 
	{
		//determines if the character passed in is a vowel or not
		boolean pr_isAVowel = false;
		char vowels[] = { 'a', 'e', 'i', 'o', 'u' };
		if ((x == vowels[0]) || (x == vowels[1]) || (x == vowels[2])
				|| (x == vowels[3]) || (x == vowels[4])) 
		{
			pr_isAVowel = true;
		} else {
			pr_isAVowel = false;
		}

		return pr_isAVowel;
	}
	public static void menu() throws Exception 
	{
		//Prints the menu and catches any errors entered
		System.out.println();
		System.out.println("Would you like to:");
		System.out.println();
		System.out.println("(1) Analyze a word, sentence or paragraph");
		System.out.println();
		System.out.println("(2) Analyze a file");
		System.out.println();
		System.out.println("(3) Quit");
		try 
		{
			String choice = EasyScanner.nextString();
			if (choice.length() > 1)
			{
				System.out.println();
				System.out.println("Invalid input");
				System.out.println();
				System.out.println("Please select numbers 1 to 3 only.");
				main(null);
			}else if (choice.length() == 1)
			{
				int choiceInt = Integer.valueOf(choice);
				do 
				{
					if (choiceInt == 1) 
					{
						System.out.println();
						double[] charFreqStr = stringAnalysis();
						output(charFreqStr);
					} 
					else if (choiceInt == 2) 
					{
						System.out.println();
						double[] charFreqFile = fileAnalysis();
						output(charFreqFile);
					} 
					else if (choiceInt == 3)
					{
						System.out.println();
						System.out.println("Thank you for using my text analysis program.");
						System.out.println();
						System.out.println("Have a great day. Goodbye. ");
						System.out.println();
						System.exit(0);
					}
					if ((choiceInt < 1) || (choiceInt > 3))
					{
						System.out.println();
						System.out.println("Invalid input");
						System.out.println();
						System.out.println("Please select numbers 1 to 3 only.");
						main(null);
					}
				} while (choiceInt != 3);
			}
		} catch (NumberFormatException nfe)
	    {
			System.out.println();
			System.out.println("Invalid input");
			System.out.println();
			System.out.println("Please select numbers only.");
			main(null);
		}
	}   
	public static double[] stringAnalysis() 
	{
		//Allows for the input of a string and passes the string into the analysis class
		String pr_input = "";
		while (pr_input == "") 
		{
			System.out.println();
			System.out.println("Please enter your word, sentence or paragraph now, enter exit or press Enter to return to main menu:");
			System.out.println();
			try 
			{
				pr_input += EasyScanner.nextString();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		if (pr_input.equals("exit") || pr_input.equals("") || pr_input.equals("EXIT") || pr_input.equals(null)) 
		{
			try 
			{
				main(null);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		st_stringForAnalysis = pr_input.toLowerCase();
		double[] pr_charFreq = Analyzer.analyzer(st_stringForAnalysis);
		return pr_charFreq;
	}
	public static double[] fileAnalysis() throws Exception 
	{
		//Allows for the input of a file and passes the string made from the file into the analysis class
		String pr_fileName = null;
		String line;
		try 
		{
			while (pr_fileName == null)
			{
				System.out.println();
				System.out.println("Please enter the full file path now, enter exit or press Enter to return to main menu:");
				pr_fileName = EasyScanner.nextString();
				String pr_fileName_lc = pr_fileName.toLowerCase();
				if (pr_fileName_lc.equals("exit") || pr_fileName_lc.equals(null) || pr_fileName_lc.equals("")) 
				{
					try 
					{
						main(null);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
			FileReader fr = new FileReader(pr_fileName);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("\nAnalysing.........");
			while ((line = br.readLine()) != null) 
			{
				String inStr_lc = line.toLowerCase();
				st_stringForAnalysis += inStr_lc;
			}
			br.close();
		} catch (Exception ee) 
		{
			System.out.println("There was an error processing your file. Please try again.");
			fileAnalysis();
		}
		double[] pr_charFreq = Analyzer.analyzer(st_stringForAnalysis);
		return pr_charFreq;
	}
	public static void output(double[] charFreqStr) throws IOException 
	{
		//Organises and creates the bar chart and handles all the other output options
		char pu_char;
		System.out.println();
		for (int x = 0; x < st_inArrChar.length; x++) 
		{
			double percent = (charFreqStr[x]/st_totalChar*100);
			String bar = bar(st_inArrChar[x],percent);
			double mostFreq = highestPercent(charFreqStr);
			String paddedBar = padding(bar,mostFreq);
			if (charFreqStr[x] == 0)
			{
				System.out.println(bar + " N/A " + charFreqStr[x]);
			}
			else
			{
				System.out.println(paddedBar + " " + df.format(percent)+ "% (" + df2.format(charFreqStr[x]) + " times)");
				}
		}
		System.out.println();
		System.out.println("Would you like to see other analytical statistics of the string or file? (Y/N)");
		pu_char = EasyScanner.nextChar();
		if((pu_char == 'y') || (pu_char == 'Y'))
		{
			
			System.out.println("the total number of letters used is " + df2.format(st_totalChar) + ",");
			System.out.println("this sentence, word, paragraph or file contains "+ st_vowel + " vowels and " + st_consonant + " consonants,");
			System.out.println("there are also " + st_puncCount + " punctuation marks used,");
			System.out.println("And finally there are " + st_numberCount + " numbers used.");
		}
		System.out.println();
		System.out.println("Would you like to see a bar chart of the individual word frequencies and word length frequencies? (Y/N)");
		pu_char = EasyScanner.nextChar();
		if((pu_char == 'y') || (pu_char == 'Y'))
		{
			System.out.println("\nAnalysing.........");
			System.out.println();
			WordFrequencyAnalyzer.wordFreqAnalyzer(st_stringForAnalysis);
		}
		st_stringForAnalysis = "";
		st_totalChar = 0;
		st_vowel = 0;
		st_consonant = 0;
		st_puncCount = 0;
		st_numberCount = 0;
		st_wordCount = 0;
	}
	private static double highestPercent(double[] charFreqStr)
	{
		//Calculates the most used letter and returns that value
		double pr_mostFreq = 0;
		for (int i = 0; i < charFreqStr.length; i++)
		{	
			double percent = (charFreqStr[i]/st_totalChar*100);
			if (percent > pr_mostFreq)
			{
				pr_mostFreq = percent;
			}
		}
		return pr_mostFreq;
	}
	public static void main(String[] args) throws Exception 
	{
		//Prints the menu
		menu();
	}
}