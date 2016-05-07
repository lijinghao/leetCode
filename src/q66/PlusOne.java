package q66;

public class PlusOne {
/*
 *  Given a non-negative number represented as an array of digits, plus one to the number.

	The digits are stored such that the most significant digit is at the head of the list.
 */

	public static int[] plusOne(int[] digits) {
		int[] result = {};
		if(null == digits || 0 == digits.length){
			return result;
		}else{
			for(int i=digits.length-1; i>=0; i--){
				if(9 == digits[i]){
					if(0 == i){
						result = new int[digits.length+1];
						result[0] = 1;
						return result;
					}else{
						digits[i] = 0;
					}
				}else{
					digits[i]++;
					return digits;
				}
			}
		}
        return result;
    }
	public static void main(String[] args) {
		int[] digits = {1,4,5,9,9};
		int[] result = plusOne(digits);
		for(int e : result){
			System.out.print(e);
		}
		
	}
}
