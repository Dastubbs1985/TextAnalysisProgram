//Imports all required imports
import java.util.Scanner;
public class EasyScanner 
{
	//Class created to allow only once required import of the scanner
	static Scanner keyboard = new Scanner(System.in);
	public static int nextInt()
	{
		//Allows user to input a number(No decimal places)
		keyboard.reset();
		int i = keyboard.nextInt();
		return i;
	}
	public static double nextDouble()
	{
		//Allows user to input a number including a decimal point
		keyboard.reset();
		double d = keyboard.nextDouble();
		return d;
	}
	public static String nextString()
	{
		//Allows user to input a string
		keyboard.reset();
		String s = keyboard.nextLine();
		return s;
	}
	public static char nextChar()
	{
		//Allows user to input a character
		keyboard.reset();
		char c = keyboard.next().charAt(0);
		keyboard.nextLine();
		return c;
	}
}