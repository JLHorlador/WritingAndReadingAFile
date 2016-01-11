import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class WriteFile 
{
	public static void main(String[] args)
	{
		String[] words = {"Who You Gonna Call?", "GHOSTBUSTERS!", "Just kidding!"};
		String[] words2 = {"Testing!", "Is someone there?", "HELLO????", "ANYONE HERE!?!?"};
		try 
		{
			PrintWriter pw = new PrintWriter("hello.txt");		//creates text file in project directory if did not specify location
			for (int i = 0; i < words.length; i++)
			{
				pw.print(words[i]);		//prints all the words in the first array, each separated by a <Space>
				pw.print("<Space>");
			}
			
			pw.print("<ENDOFLINE>");	//prints <ENDOFLINE> at the end of the first line
			pw.println();
			
			for (int i = 0; i < words2.length; i++)
			{
				pw.print(words2[i]);	//does the same thing within the first for loop but utilizes the second String array
				pw.print("<Space>");
			}
			pw.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("hello.txt"));
			String line;
			String[] bob;
			while ((line = reader.readLine()) != null)
			{
				bob = line.split("<Space>");		//resizes the bob array and populates it with the words between the <Space> keywords
				for (int i = 0; i < bob.length; i++)
				{
					if (bob[i].equals("<ENDOFLINE>"))		//if bob has the keyword <ENDOFLINE>, prints a new line in console
						System.out.println();
					else
						System.out.print(bob[i] + " ");		//otherwise print the word in the current index of the array
				}
			}
			reader.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
