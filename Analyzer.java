public class Analyzer
{
	public static double[] analyzer(String pr_input)
	{
		//Computes the analysis of the string or file entered by the user
		int counter = 0;
		char char_in[] = pr_input.toCharArray();
		AssignmentTextAnalyzer.st_puncCount = AssignmentTextAnalyzer.punctuation(char_in);
		AssignmentTextAnalyzer.st_numberCount = AssignmentTextAnalyzer.numbers(char_in);
		double [] pr_charFreq = new double [AssignmentTextAnalyzer.st_inArrChar.length];
		for (int i = 0; i < AssignmentTextAnalyzer.st_inArrChar.length; i++) 
		{	
			for (int a = 0; a < char_in.length; a++) 
			{
				if (char_in[a] == AssignmentTextAnalyzer.st_inArrChar[i]) 
					{	
					if (AssignmentTextAnalyzer.Vowel(char_in[a]) == true) 
					{
						AssignmentTextAnalyzer.st_vowel++;
					} else {
						AssignmentTextAnalyzer.st_consonant++;
					}
					AssignmentTextAnalyzer.st_totalChar++;
					counter++;
					continue;
				}
			}
			pr_charFreq[i] = counter;
			counter = 0;
		}
		return pr_charFreq;
	}
}