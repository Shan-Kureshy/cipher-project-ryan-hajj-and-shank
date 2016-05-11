
public interface encoder {
	
	
	public void subBytes();// hex value == location on 16x16 matrix
	
	public void shiftRows();
	
	public void mixColumns();
	 
	public void addRoundKey();// 4x4 matrix with hex values added to original to create new hex values
	
}
