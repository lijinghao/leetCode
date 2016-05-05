package q283;

public class MoveZeroes {
	/*
	 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	   For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	
	   Note:
	   You must do this in-place without making a copy of the array.
	   Minimize the total number of operations.
	 */
	public static void moveZeroes(int[] nums) {
		if(null == nums || 1 == nums.length){
			return;
		}
        int zero=0, nonzero=0;
        while(nonzero < nums.length){
        	while(nonzero < nums.length && nums[nonzero] == 0){
        		nonzero++;
        	}
        	while(zero < nums.length && nums[zero] != 0){
        		zero++;
        	}
        	if(nonzero == nums.length || zero == nums.length){
        		return;
        	}else if(nonzero < zero){
        		nonzero = zero+1;
        	}else{
        		nums[zero] = nums[nonzero];
            	nums[nonzero] = 0;
            	zero++;
            	nonzero++;
        	}
        	
        }
    }
	
	public static void main(String[] args){
//		int[] nums = {0, 1, 0, 3, 12};
//		int[] nums = {0, 0};
		int[] nums = {1, 0};
		for(int e : nums){
			System.out.print(e+", ");
		}
		System.out.println("");
		moveZeroes(nums);
		for(int e : nums){
			System.out.print(e+", ");
		}
	}

}
