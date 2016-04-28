package q27;

public class RemoveElement {
	/*
	 * Given an array and a value, remove all instances of that value in place and return the new length.

	   Do not allocate extra space for another array, you must do this in place with constant memory.

       The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	 */
	public static int removeElement(int[] nums, int val) {
		
		int count = 0;
		for(int i = 0; i < nums.length;i++){
			if(val != nums[i]){
				nums[count] = nums[i];
				count++;
			}
		}
		return count;

    }
	
	public static void main(String[] args){
		int[] nums = {2};
		int val = 3;
		int result = RemoveElement.removeElement(nums, val);
		
		System.out.println(result);
	}
}
