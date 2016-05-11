
public class Tester {

	public static void main(String[] args) {
		encrypter test = new encrypter();
		String[][] testVal = test.getAns();
		
		
		//TEST CONSTRUCTOR
		for(int r = 0; r < 4; r++){
			for(int c = 0; c< 4 ; c++){
				System.out.print(testVal[r][c]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//TEST SUB BYTES
		test.subBytes();
		testVal = test.getAns();
		
		for(int r = 0; r < 4; r++){
			for(int c = 0; c< 4 ; c++){
				System.out.print(testVal[r][c]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		//TEST SHIFT ROWS
		test.shiftRows();
		testVal = test.getAns();
		
		for(int r = 0; r < 4; r++){
			for(int c = 0; c< 4 ; c++){
				System.out.print(testVal[r][c]+ " ");
			}
			System.out.println();
		}
	}

}
