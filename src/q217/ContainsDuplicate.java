package q217;
import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicate {
/*
 * 问题：Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
	public static boolean containsDuplicate(int[] nums) {
		
		if(null == nums || nums.length < 2){
			return false;
		}
		Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			if(hMap.containsKey(nums[i])){
				return true;
			}else{
				hMap.put(nums[i], i);
			}
		}
        return false;
    }

	public static void main(String[] args){
		
	}
}
