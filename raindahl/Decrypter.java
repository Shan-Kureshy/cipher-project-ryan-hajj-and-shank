
public class Decrypter implements encoder{
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
private String[][] plainText;// change to private after testing
private String[][] cipherText;// change to private after testing
private String[][] roundKey = new String[4][4];
private int[][] lineMap = new int[][] {{2,3,1,1},
										{1,2,3,1},
										{1,1,2,3},
										{3,1,1,2}};
public Decrypter(String binary){
	plainText = conversions.BinaryToHex(binary);
	cipherText = conversions.BinaryToHex(binary);
}
public Decrypter(){
	plainText = new String[][]{{"00","01","ff","f0"},
							   {"55","a7","bc", "0f"},
							   {"23","19","20","77"},
							   {"23","19","20","12"}};
	cipherText = plainText;
}
	@Override
	public void subBytes() {
		// TODO Auto-generated method stub
		
		for(int r = 0; r < 4; r++){
			for(int c = 0; c < 4; c++){
				for(int rs = 0; rs< 16; rs++){
					for(int cs = 0; cs< 16; cs++){
						if(cipherText[r][c].equals(codeMatrix[rs][cs])){
							
							if(rs == 10)plainText[r][c] = "a";
							else if(rs == 11)plainText[r][c] = "b";
							else if(rs == 12)plainText[r][c] = "c";
							else if(rs == 13)plainText[r][c] = "d";
							else if(rs == 14)plainText[r][c] = "e";
							else if(rs == 15)plainText[r][c] = "f";
							else plainText[r][c] = Integer.toString(rs);
							
							
							if(cs == 10)plainText[r][c] += "a";
							else if(cs == 11)plainText[r][c] += "b";
							else if(cs == 12)plainText[r][c] += "c";
							else if(cs == 13)plainText[r][c] += "d";
							else if(cs == 14)plainText[r][c] += "e";
							else if(cs == 15)plainText[r][c] += "f";
							else plainText[r][c] += Integer.toString(cs);
						}
					}
				}
			}
		}
		
	}
	
	
	public void shiftRow(int r){
		String temp = cipherText[r][3];
		for(int y = 3; y>0;y--){
			cipherText[r][y] = cipherText[r][y-1];
			
			
		}
		cipherText[r][0] = temp;
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
