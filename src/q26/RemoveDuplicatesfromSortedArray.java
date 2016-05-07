package q26;

public class RemoveDuplicatesfromSortedArray {
/*
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	For example,
	Given input array nums = [1,1,2],
	
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
	
	public static int removeDuplicates(int[] nums) {
		if(null == nums || 0 == nums.length){
			return 0;
		}else if(1 == nums.length){
			return 1;
		}else{
			//i用于遍历nums数组，count保存现在不重复的元素的下标,count下标之前的元素都是不重复的
			int count = 0;
			for(int i=1; i<nums.length; i++){
				if(nums[i] != nums[count]){
					count++;
					nums[count] = nums[i];
				}
			}
			return count+1;//返回数组长度是最后的下标count+1
		}
    }

	public static void main(String[] args){
		int[] nums = {};
		int l = removeDuplicates(nums);
		System.out.println(l);
		for(int i=0; i<l; i++){
			System.out.print(nums[i]+" ");
		}
	}
}
