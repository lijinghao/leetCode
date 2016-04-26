package Q27;

public class RemoveElement {
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
