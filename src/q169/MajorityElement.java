package q169;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class MajorityElement {
/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

   You may assume that the array is non-empty and the majority element always exist in the array.
 */
    public static int majorityElement(int[] nums) {
    	/****************方法一，先排序再查找******************/
//    	if(null == nums){
//    		return 0;
//    	}else if(1 == nums.length){
//    		return nums[0];
//    	}
//    	Arrays.sort(nums);
//    	for(int i=1, count = 1; i<nums.length; i++){
//    		if(nums[i] == nums[i-1]){
//    			count++;
//    			if(count > nums.length/2){
//    				return nums[i];
//    			}
//    		}else{
//    			count = 1;
//    		}
//    	}
//        return 0;
        
        /****************方法二，使用hashmap******************/
    	if(null == nums){
    		return 0;
    	}else if(1 == nums.length){
    		return nums[0];
    	}
    	Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
    	for(int i=0; i<nums.length; i++){
    		if(hMap.containsKey(nums[i])){
    			hMap.put(nums[i], hMap.get(nums[i])+1);
    			if(hMap.get(nums[i]) > nums.length/2){
    				return nums[i];
    			}
    		}else{
    			hMap.put(nums[i], 1);
    		}
    	}
        return 0;
    }
	public static void main(String[] args){
		int[] nums = {2,2,1,1,1,2,2};
		int m = majorityElement(nums);
		for(int i=0; i< nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println("");
		System.out.println(m);
	}
}
