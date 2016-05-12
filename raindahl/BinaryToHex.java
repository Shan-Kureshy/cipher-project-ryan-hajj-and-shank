import java.util.Scanner;


public class BinaryToHex {

	private static String[][] hexMatrix = new String[4][4];
	private String s = "00000001001000110100010101100111100010011010101111001101111011110000000100100011010001010110011110001001101010111100110111101111";
	
	
	public static String[][] BinaryToHexa(String s)
	{
		//String test = "00101100010111110000";
		String temp = "";
		int hexCount = 0;
		String hexa = "";
		String result = "";
		// line to read String
		
		// Line to read and take 4 binary values and convert into hexa String
		for (int i = 0; i < s.length(); i += 4)
		{
			for (int j = 0; j < 4; j++)
			{
				temp += s.substring(i);
				if (j == 0);
				{
					if (temp == "1")
					hexCount += 8;
				}
				if (j == 1);
				{
					if (temp == "1")
					hexCount += 4;
				}
				if (j == 2);
				{
					if (temp == "1")
					hexCount += 2;
				}
				if (j == 3);
				{
					if (temp == "1")
					hexCount += 1;
				}
				temp = "";
			}
			// line to add them into a string
			if (hexCount == 0)
			{
				hexa += "0";
			}
			if (hexCount == 1)
			{
				hexa += "1";
			}
			if (hexCount == 2)
			{
				hexa += "2";
			}
			if (hexCount == 3)
			{
				hexa += "3";
			}
			if (hexCount == 4)
			{
				hexa += "4";
			}
			if (hexCount == 5)
			{
				hexa += "5";
			}
			if (hexCount == 6)
			{
				hexa += "6";
			}
			if (hexCount == 7)
			{
				hexa += "7";
			}
			if (hexCount == 8)
			{
				hexa += "8";
			}
			if (hexCount == 9)
			{
				hexa += "9";
			}
			if (hexCount == 10)
			{
				hexa += "a";
			}
			if (hexCount == 11)
			{
				hexa += "b";
			}
			if (hexCount == 12)
			{
				hexa += "c";
			}
			if (hexCount == 13)
			{
				hexa += "d";
			}
			if (hexCount == 14)
			{
				hexa += "e";
			}
			if (hexCount == 15)
			{
				hexa += "f";
			}

			hexCount = 0;
		}
		
		for (int i = 0; i < hexa.length(); i += 2)
		{
			result += hexa.substring(i, i+2);
			result += " ";
		}
		
		Scanner detect = new Scanner(result);

		// line to take 2 of each and put them into 1 spot of the array
		for (int i = 0; i < hexMatrix.length; i++)
		{
			for (int j = 0; j < hexMatrix[0].length; j++)
			{
				hexMatrix[i][j] = detect.next();
			}
				
		}
		detect.close();
		// return matrix
		return hexMatrix;
	}
	
}

