package q189;

public class RotateArray {
/*
 * Rotate an array of n elements to the right by k steps.

   For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

   Note:
   Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/
	
	public static void rotate(int[] nums, int k) {
		if(!(null == nums || 0 == k)){
			/***********方法一，复制数组*************/
//			int[] tempArray = new int[nums.length];
//			for(int i=0; i<nums.length; i++){
//				tempArray[i] = nums[i];
//			}
//			int rotate = k % nums.length;
//			if(0 != rotate){
//				int i = 0;
//				for(; i+rotate<nums.length; i++){
//					nums[i+rotate] = tempArray[i];
//				}
//				for(int j=0; i<nums.length; i++,j++){
//					nums[j] = tempArray[i];
//				}
//			}
			
			/***********方法二，计算空位*************/
			int rotate = k % nums.length;
			if(0 != rotate){
				int from = 0, to = -1, value = nums[0], start = 0;
				for(int i=0; i<nums.length; i++){//基本思想是从下标0开始，每次计算现在所在下标的元素要移到的目的下标，不断循环
					to = (from+k)%nums.length;
					int tmp = nums[to];
					nums[to] = value;
					value = tmp;
					from = to;
					if(from == start){//start是该循环的开始下标，from==start时说明出现了循环，而如果循环次数小于了nums.length时，说明还有其余元素没有rotate，这时就把from下标和start下标右移一位继续执行
						from++;
						start++;
						value = nums[from];
					}
					
				}
				
			}
					
		}
    }
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		int k = 2;
		rotate(nums, k);
		
		for(int n : nums){
			System.out.print(n+"  ");
		}
	}
}
