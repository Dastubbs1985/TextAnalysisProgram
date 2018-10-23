//Imports all required imports
import java.io.IOException;
public class WordFrequencyAnalyzer 
{
	//Declaration and initialization of the static variables
	static String mostUsedWord = "";
	static double mostUsedWordFreq = 0;
	static int mostFreqLength = 0;
	static double mostUsedFreq = 0;
	static int [] wordLengths = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	public static String padding(String pu_inStr, int longestWord)
		{
			//Pads out the printed words in the word frequency bar chart to ensure all the bars start in the same position
			String pu_outStr = pu_inStr;
			String pu_space = " ";
			String bar = ":";
			while (pu_outStr.length() < longestWord)
			{
				pu_outStr = pu_outStr + pu_space;
			}
			if (pu_outStr.length() == longestWord)
			{
				pu_outStr = pu_outStr + bar;
			}
			return pu_outStr;
		}
	public static String padding2(String pu_inStr, int mostFreq)
		{
			//Pads out the bar to align the numbers and percentages on the right of the bar chart
			String pu_outStr = pu_inStr;
			String pu_space = " ";
			while (pu_outStr.length() < mostFreq)
			{
				pu_outStr = pu_outStr + pu_space;
			}
			return pu_outStr;
		}
	private static double highestPercent(String [] strArrIn, double[] pr_wordFreq)
		{
			//Calculates the most used word and returns that value
			double pr_mostFreq = 0;
			for (int i = 0; i < pr_wordFreq.length; i++)
			{	
				if (pr_wordFreq[i] > pr_mostFreq)
				{
					pr_mostFreq = pr_wordFreq[i];
					mostUsedWord = strArrIn[i];
					mostUsedFreq = pr_mostFreq;
				}
			}
			return pr_mostFreq;
		}
	public static String bar(String pu_x, int charFreqStr) 
		{
			//Creates that bar for the bar chart
			String str = pu_x;
			String pad = "|";
			while (str.length() < charFreqStr)
			{
				str = str + pad; 
			}
			return str;
		}
	static double mostFreq(int[] Lengths, double[] wordLengthsFreq)
		{
			//Calculates the most used word length and returns that value
			double pr_mostFreq = 0;
			for (int i = 0; i < wordLengthsFreq.length; i++)
			{	
				if (wordLengthsFreq[i] > pr_mostFreq)
				{
					pr_mostFreq = wordLengthsFreq[i];
					mostFreqLength = Lengths[i];
					mostUsedFreq = pr_mostFreq;
				}
			}
			return pr_mostFreq;
		}
	public static void wordFreqAnalyzer(String  pr_input) throws IOException 
		{
			//Performs extra analysis of the string and creates the output
			String [] words = pr_input.split(" ");
			int unique = 0;
			int longest = 0;
			int sz = words.length;
			String [] finalWords = new String[sz];
			int i = 0, j = 0; 
			int counter = 0;
			int longerWords = 0;
			int counterWordLengths = 0;
			double [] wordLengthsFreq = new double [wordLengths.length];
			double [] pr_wordFreq = new double [sz];
			for (int x = 0; x < words.length; x++)
			{
				String strippedWord = words[x].replaceAll("[0-9]", " ");
				words[x] = strippedWord;
				strippedWord = words[x].replaceAll("\\W", " ");
				words[x] = strippedWord;
				strippedWord = words[x].replaceAll("\\W", "");
				finalWords[x] = strippedWord;
			}
			AssignmentTextAnalyzer.st_wordCount = AssignmentTextAnalyzer.wordCount(finalWords);
			for (int y = 0; y < finalWords.length; y++)
			{
				if (finalWords[y].length() > longest)
				{
					if (finalWords[y].length() == 20)
					{
						System.out.println(finalWords[y]);
					}
					longest = finalWords[y].length();
				}
			}
			for (i = 0; i < sz; i++)
			{
					for(j = 0; j < sz; j++)
					{
						if (j < i && finalWords[i].equals(finalWords[j]))
						{
							break;
						}
						if(finalWords[j].equals(finalWords[i]))
						{	
							counter++;
						}
						if(j == sz - 1)
						{
							pr_wordFreq[i] = counter;
						}
					}
					counter = 0;
			}
			for (int x = 0; x < sz; x++) 
			{
				if (pr_wordFreq[x] == 1)
				{
					unique++;
				}
			}
			for (i = 0; i < wordLengths.length; i++)
			{
				for(j = 0; j < finalWords.length; j++)
				{	
					int test = finalWords[j].length();
					if (test == wordLengths[i])
					{
						counterWordLengths++;
					}
					wordLengthsFreq[i] = counterWordLengths;
				}
				counterWordLengths = 0;
			}
			for (int d = 0;	d < finalWords.length;d++)
			{
				if (finalWords[d].length() > 20)
				{
					longerWords++;
				}
			}
			for (i = 0; i < sz; i++)
			{
					for(j = 0; j < sz; j++)
					{
						if (j < i && finalWords[i].equals(finalWords[j]))
						{
							break;
						}
						if(finalWords[j].equals(finalWords[i]))
						{	
							counter++;
						}
						if(j == sz - 1)
						{
							pr_wordFreq[i] = counter;
						}
					}
					counter = 0;
			}
			System.out.println("WORD FREQUENCY CHART");
			for (int y = 0; y < sz; y++) 
			{
				double mostFreq = highestPercent(finalWords,pr_wordFreq);
				if (finalWords.length > 50)
				{
					System.out.println("\nBar chart too long to print on screen.");
					break;
				}
				if (mostFreq > 100)
				{
					System.out.println("\nBar chart too large to print on screen.");
					break;
				}
				double percent = pr_wordFreq[y]/AssignmentTextAnalyzer.st_wordCount*100;
				String paddedBar = padding(finalWords[y],longest);
				if ((pr_wordFreq[y] == 0) || (finalWords[y].equals("")))
				{
					continue;
				}
				System.out.println(paddedBar + " " + AssignmentTextAnalyzer.df.format(percent) + "%" + " (" + AssignmentTextAnalyzer.df2.format(pr_wordFreq[y]) + ")" + " times.");
			}
			System.out.println();
			System.out.println("There is a grand total of " + unique + " unique words.");
			System.out.println("and the most used word was " + "\"" + mostUsedWord + "\"" + " used " + mostUsedFreq + " times.");
			System.out.println();
			mostFreq(wordLengths,wordLengthsFreq);
			System.out.println("WORD LENGTHS FREQUENCY CHART");
			for (int x = 0; x < wordLengths.length; x++) 
			{
				String number = String.valueOf(wordLengths[x]) + ":";
				String letter = padding(number,7);
				if (wordLengthsFreq[x] == 0)
				{
					System.out.println(letter + "N/A " + wordLengthsFreq[x]);
				}
				else
				{
					System.out.println(letter + AssignmentTextAnalyzer.df2.format(wordLengthsFreq[x]));
				}
			}
			System.out.println();
			System.out.println("The total number of words in the string is " + AssignmentTextAnalyzer.st_wordCount + ",");
			System.out.println("There are " + longerWords + " words that have more than 20 letters in them.");
			System.out.println();
			System.out.println("The most frequent word length used is " + mostFreqLength + " and");
			System.out.println("is used " + AssignmentTextAnalyzer.df2.format(mostUsedFreq) + " times.");
		}
}