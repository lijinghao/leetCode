package q216;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
/*
 *  Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

	Ensure that numbers within the set are sorted in ascending order.
	
	
	Example 1:
	
	Input: k = 3, n = 7
	
	Output:
	
	[[1,2,4]]
	
	Example 2:
	
	Input: k = 3, n = 9
	
	Output:
	
	[[1,2,6], [1,3,5], [2,3,4]]
 */
	public static List<List<Integer>> combinationSum3(int k, int n) {
		/************使用DFS递归解决**************/
//        List<Integer> numbers = null;
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        
//        if(1>k || 9<k || 0>n || 45<n || n<k){
//        	return result;
//        }else{
//        	int minsum = 0, maxsum = 0;
//        	for(int i=1; i<=k; i++){
//        		minsum = minsum + i;
//        		maxsum = maxsum + (10 - i);
//        	}
//        	if(minsum > n){
//        		return result;
//        	}else if(maxsum < n){
//        		return result;
//        	}else{
//        		compute(result, numbers, 0, k, n);
//        		return result;
//        	}
//        }   
		
		List<Integer> numbers = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		compute(result, numbers, 1, k, n);
		return result;
    }
	
//	public static void compute(List<List<Integer>> result, List<Integer> numbers, int sum, int k, int n){
//		if(0 == sum){//刚开始
//			if(1 == k){
//				numbers = new ArrayList<Integer>();
//				numbers.add(n);
//				result.add(numbers);
//				return;
//			}else{
//				for(int i=1; i<=9; i++){
//					if(sum + i < n){
//						numbers = new ArrayList<Integer>();
//						numbers.add(i);
//						compute(result, numbers, sum+i, k-1, n);
//					}else{
//						return;
//					}
//				}
//			}
//			
//		}else if(1 == k){//还剩一个空位
//			for(int i=numbers.get(numbers.size()-1)+1; i<=9; i++){
//				if(sum + i == n){
//					numbers.add(i);
//					result.add(numbers);
//					return;
//				}
//			}
//			return;
//		}else{
//			for(int i=numbers.get(numbers.size()-1)+1; i<=9; i++){
//				if(sum + i < n){
//					List<Integer> tmp = new ArrayList<Integer>();
//					for(int e : numbers){
//						tmp.add(e);
//					}
//					tmp.add(i);
//					compute(result, tmp, sum+i, k-1, n);
//				}else{
//					return;
//				}
//			}
//			return;
//		}
//	}
	
	public static void compute(List<List<Integer>> result, List<Integer> numbers, int min, int k, int leftSum){
		if(0 == k){
			if(0 == leftSum){//正好k个数相加等于n
				result.add(numbers);
				return;
			}else{
				return;
			}
			
		}else{
			for(int i=min; i<=(leftSum<9 ? leftSum : 9); i++){
				List<Integer> tmp = new ArrayList<Integer>();
				for(int e : numbers){
					tmp.add(e);
				}
				tmp.add(i);
				compute(result, tmp, i+1, k-1, leftSum-i);
			}
			return;
		}
	}
	
	
	
	public static void main(String[] args){
		List<List<Integer>> result = combinationSum3(3,15);
		System.out.println(result);
	}
}
