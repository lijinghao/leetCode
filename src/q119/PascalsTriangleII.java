package q119;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
/*
 * Given an index k, return the kth row of the Pascal's triangle.

   For example, given k = 3,
   Return [1,3,3,1].
        1 
       1 1 
      1 2 1 
     1 3 3 1 
    1 4 6 4 1 
   Note:
   Could you optimize your algorithm to use only O(k) extra space?
 */
	public static List<Integer> getRow(int rowIndex) {
		/*方法一，根据每个位置的数的计算公式C(n,m)计算，但是因为13的阶乘超过了Integer.MAX_VALUE，所以出现负数*/
//		List<Integer> result = new ArrayList<Integer>();
//		result.add(1);//第一个数是1
//		for(int i=1; i<=rowIndex; i++){
//			int numerator=1, denominator=1;
//			for(int j=rowIndex; j>rowIndex-i; j--){
//				numerator = numerator * j;
//			}
//			for(int j=i; j>0; j--){
//				denominator = denominator * j;
//			}
//			result.add(numerator / denominator);
//		}
//        return result;
        
        /*方法二，根据下一行的数等于上一行两个数相加来计算*/
        //只要计算第k行的k/2+1个数就行，其余的只要复制之前的
		List<Integer> result = new ArrayList<Integer>();
		if(0 == rowIndex){//从第0行开始计数，有一个元素
			result.add(1);
			return result;
		}else if(1 == rowIndex){//第1行，有两个元素
			result.add(1);
			result.add(1);
			return result;
		}else{
			result.add(1);
			result.add(1);
			for(int i=2; i<= rowIndex; i++){//从第2行开始计算，一直计算到第rowIndex行
				//每一行的下标0的元素是都是1，无需计算
				//先计算前一半，不包括下标0的元素，先计算中间的元素是因为把这里计算完后直接再原list上赋值为新值不会影响这个元素之前的元素的计算
				for(int j=i/2; j>0; j--){
					result.set(j, result.get(j) + result.get(j-1));
				}
				//将前一半(不包括下标0的元素)赋值给后一半(不包括最后一个元素)
				for(int j=i/2+1; j<result.size(); j++){
					result.set(j, result.get((i+1)/2-1 - (j-(i/2+1))));
				}
				//将最后一个元素赋值为1，这一行肯定比上一行多一个元素，所以这里不再是set，而是add
				result.add(1);
			}
			return result;
		}
		
    }

	public static void main(String[] args){
		int k = 3;
		List<Integer> result = getRow(k);
		for(int e : result){
			System.out.print(e+" ");
		}
		System.out.println("");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(13*12*11*10*9*8*7*6*5*4);
		System.out.println(result.get(2));
	}
}
