package q88;

public class MergeSortedArray {
/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

   Note:
   You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		/***********方法一，使用临时数组数组*************/
//        if(null==nums1 || null==nums2 || 0==n){
//        	return;
//        }
//        int[] mergeArray = new int[m+n];
//        int i=0,j=0;
//        while(i<m && j<n){//一直循环到nums1或者nums2遍历结束
//        	if(nums1[i] < nums2[j]){
//        		mergeArray[i+j] = nums1[i];
//        		i++;
//        	}else{
//        		mergeArray[i+j] = nums2[j];
//        		j++;
//        	}
//        }
//        int count = i+j;//记录此时mergeArray最后一个元素的下标
//        //这时将剩余元素直接往nums1中放，省了复制到mergeArray再从mergeArray复制回nums1的时间
//        if(i==m){
//        	for(;j<n;j++){
//        		nums1[i+j] = nums2[j];
//        	}
//        }else{
//        	for(int end=m+n-1,first=m-1;i<m;i++,first--,end--){
//        		nums1[end] = nums1[first];
//        	}
//        }
//        for(int c=0; c<count; c++){
//        	nums1[c] = mergeArray[c];
//        }
        
        /***********方法二，从后往前存放*************/
		if(null==nums1 || null==nums2 || 0==n){//m=0时没有错
        	return;
        }
		for(int end=m+n-1,i=m-1,j=n-1; end>=0; end--){
			if(0 > i){
				nums1[end] = nums2[j];
				j--;
			}else if(0 > j){
				nums1[end] = nums1[i];
				i--;
			}else if(nums1[i] > nums2[j]){
				nums1[end] = nums1[i];
				i--;
			}else{
				nums1[end] = nums2[j];
				j--;
			}
		}
    }

	public static void main(String[] args){
		int[] nums1 = {1,0};
		int m = 1;
		int[] nums2 = {2};
		int n = 1;
		merge(nums1, m, nums2, n);
	}
}
