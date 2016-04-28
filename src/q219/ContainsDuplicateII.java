package q219;
import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		/*************下面这个方法运行时间超时了，因为是O(n2)的时间复杂度**************/
		/*
		if(null == nums || nums.length < 2 || 0 == k) return false;
		for(int first=0; first<nums.length-1;first++){
			if(first + k < nums.length){
				for(int second = first + 1;second <= first + k;second++){
					if(nums[first] == nums[second]){
						return true;
					}
				}
			}else{
				for(int second = first + 1;second < nums.length;second++){
					if(nums[first] == nums[second]){
						return true;
					}
				}
			}
			
		}
        return false;
        */
		
		/*************参考网上的方法，使用hashmap**************/
		if(null == nums || nums.length < 2 || 0 == k) return false;
		Map<Integer, Integer> h = new HashMap<Integer, Integer>();//将nums数组存储到hashmap中，key为nums数组中的值，value为对于的下标
		for(int i=0; i<nums.length; i++){//遍历数组
			if(h.containsKey(nums[i])){//如果该值存在于hashmap的key中，则取该值下标与value比较，若相差小于a则说明比对成功，返回true，否则将新的下标写入value中
				if(h.get(nums[i]) + k >= i){
					return true;
				}else{
					h.put(nums[i], i);
				}
			}else{//如果该值不存在于hashmap的key中，则直接将该值作为key，下标作为value写入hashmap中
				h.put(nums[i], i);
			}
		}
		return false;
    }
	
	public static void main(String[] args){
		int[] nums = {0,1,2,3,2,5};
		int k = 3;
		boolean result = containsNearbyDuplicate(nums, k);
		System.out.println(result);
	}
}
