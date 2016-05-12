import java.util.Scanner;


public class BinaryToHex {

	private static String[][] hexMatrix = new String[4][4];
	//private static String s = "00000001001000110100010101100111100010011010101111001101111011110000000100100011010001010110011110001001101010111100110111101111";
	private static String s = "00000000000000010000001000000011000010000000010100000110000001110000100000001001000010100000101100001100000011010000111000001111";
	private static int num = 12; 
	
	public static String[][] binaryMatrix(String s)
	{
		 String[][] text = new String[4][4];
		 String bleh = "";
		 for (int i = 0; i < s.length(); i+= 8)
			{
				bleh+= s.substring(i, i+8);
				bleh += " ";
			}
		 Scanner detect = new Scanner(bleh);
			
			for (int r = 0; r < 4; r++)
			{
				for (int c = 0; c < 4; c++)
				{
					text[r][c] = detect.next();
				}
			}
			return text;
	}
	
	public static String[][] binToInt(String[][] bob)
	{
		String[][] output = bob;
		int count =0;
		for (int r = 0; r < 4; r++)
		{
			for (int c = 0; c < 4; c++)
			{
				if(output[r][c].substring(0,1).equals("1")) count += 128;
				if(output[r][c].substring(1,2).equals("1")) count += 64;
				if(output[r][c].substring(2,3).equals("1")) count += 32;
				if(output[r][c].substring(3,4).equals("1")) count += 16;
				if(output[r][c].substring(4,5).equals("1")) count += 8;
				if(output[r][c].substring(5,6).equals("1")) count += 4;
				if(output[r][c].substring(6,7).equals("1")) count += 2;
				if(output[r][c].substring(7,8).equals("1")) count += 1;
				if (Integer.toHexString(count).length() == 1)output[r][c] = "0"+Integer.toHexString(count);
				else output[r][c] = Integer.toHexString(count);
			}
		} 
		
		return output;
	}
	
	
	
	public static void main(String[] args)
	{
		for (int r = 0; r < 4; r++)
		{
			for (int c = 0 ; c < 4; c++)
			{
				
				System.out.print(binToInt(binaryMatrix(s))[r][c] +" ");
			}
			System.out.println();
		}
	}
}

