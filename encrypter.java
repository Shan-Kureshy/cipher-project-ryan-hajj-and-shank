
public class encrypter implements encoder{
	private String[][] codeMatrix = new String[][]{{"63","7c","77","7b","f2","6b","6f","c5","30","01","67","2b","fe","d7","ab","76"},
												   {"ca","82","c9","7d","fa","59","47","f0","ad","d4","a2","af","9c","a4","72","c0"},
												   {"b7","fd","93","26","36","3f","f7","cc","34","a5","e5","f1","71","d8","31","15"},
												   {"04","c7","23","c3","18","96","05","9a","07","12","80","e2","eb","27","b2","75"},
												   {"09","83","2c","1a","1b","6e","5a","a0","52","3b","d6","b3","29","e3","2f","84"},
												   {"53","d1","00","ed","20","fc","b1","5b","6a","cb","be","39","4a","4c","58","cf"},
												   {"d0","ef","aa","fb","43","4d","33","85","45","f9","02","7f","50","3c","9f","a8"},
												   {"51","a3","40","8f","92","9d","38","f5","bc","b6","da","21","10","ff","f3","d2"},
												   {"cd","0c","13","ec","5f","97","44","17","c4","a7","7e","3d","64","5d","19","73"},
												   {"60","81","4f","dc","22","2a","90","88","46","ee","b8","14","de","5e","0b","db"},
												   {"e0","32","3a","0a","49","06","24","5c","c2","d3","ac","62","91","95","e4","79"},
												   {"e7","c8","37","6d","8d","d5","4e","a9","6c","56","f4","ea","65","7a","ae","08"},
												   {"ba","78","25","2e","1c","a6","b4","c6","e8","dd","74","1f","4b","bd","8b","8a"},
												   {"70","3e","b5","66","48","03","f6","0e","61","35","57","b9","86","c1","1d","9e"},
												   {"e1","f8","98","11","69","d9","8e","94","9b","1e","87","e9","ce","55","28","df"},
												   {"8c","a1","89","0d","bf","e6","42","68","41","99","2d","0f","b0","54","bb","16"}};
	
	
	private String[][] roundKey = new String[][]{{"a0","88","23","2a"},
												 {"fa","54","a3","6c"},
												 {"fe","2c","39","76"},
											 	 {"17","b1","39","05"}
												 }; 
	private String[][] plainText;// change to private after testing
	private String[][] cipherText;// change to private after testing
	public encrypter(String binary){
		plainText = conversions.BinaryToHex(binary);
		cipherText = conversions.BinaryToHex(binary);
	}
	
	public encrypter(){
		plainText = new String[][]{{"00","01","ff","f0"},
								   {"55","a7","bc", "0f"},
								   {"23","19","20","77"},
								   {"23","19","20","12"}};
		cipherText = plainText;
	}
	
	public String[][] getAns(){// for testing only
		return cipherText;
	}
	
	@Override
	public void subBytes() {
		for(int r = 0; r < 4; r++){
			for(int c = 0; c < 4; c++){
				 char sum1 = plainText[r][c].charAt(0);
				 int fSum1;
				 if(sum1-48 <= 9) fSum1 = sum1 - 48;
				 else fSum1 = sum1 - 87;
				 
				 
				 char sum2 = plainText[r][c].charAt(1);
				 int fSum2;
				 if(sum2 - 48 <= 9) fSum2 = sum2 - 48;
				 else fSum2 = sum2 - 87;
				 cipherText[r][c] = codeMatrix[fSum1][fSum2];
			}
		}
		
	}
	
	public void shiftRow(int r){
		String temp = cipherText[r][0];
		for(int y = 0; y<3;y++){
			cipherText[r][y] = cipherText[r][y+1];
			
			
		}
		cipherText[r][3] = temp;
	}
	
	@Override
	public void shiftRows() {
		// TODO Auto-generated method stub
		for(int r = 0; r < 4; r++){
			for(int i = 0; i < r; i++){
				this.shiftRow(r);
			}
		}
	}

	@Override
	public void mixColumns() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void addRoundKey() {
		// TODO Auto-generated method stub
		
	}
	
}
