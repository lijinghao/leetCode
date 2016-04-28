package q1;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        if(null == nums) return null;
        
        for(int first=0, second=first+1; first<nums.length-1; first++){
        	for(;second<nums.length;second++){
        		if(target == nums[first] + nums[second]){
        			int[] result = new int[2];
        			result[0] = first;
        			result[1] = second;
        			return result;
        		}
        	}
        }
        return null;
    }
	
	public static void main(String[] args){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		int[] result = twoSum(nums, target);
		if(null != result){
			System.out.println(result[0]+","+result[1]);
		}
		
	}
}
