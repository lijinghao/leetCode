package q118;
import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
/*
 *  Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
 */
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(0 == numRows){
        	return result;
        }else if(1 == numRows){
        	List<Integer> row = new ArrayList<Integer>();
        	row.add(1);
        	result.add(row);
        	return result;
        }else if(2 == numRows){//row只需要声明一次，因为第一次new出的被add到result中时会把引用赋值过去，之后只要不改变该引用指向的值就行了，所以直接再new一个，相当于改变了row指向的地址，而之前add到result中的值引用的地址不受影响
        	List<Integer> row = new ArrayList<Integer>();
        	row.add(1);
        	result.add(row);
        	row = new ArrayList<Integer>();
        	row.add(1);
        	row.add(1);
        	result.add(row);
        	return result;
        }else{//先把前两行补上，因为前两行不需要计算
        	List<Integer> row = new ArrayList<Integer>();
        	row.add(1);
        	result.add(row);
        	row = new ArrayList<Integer>();
        	row.add(1);
        	row.add(1);
        	result.add(row);
        	for(int i=2; i<numRows; i++){
        		row = new ArrayList<Integer>();
            	row.add(1);
            	for(int j=1; j<i; j++){
            		row.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
            	}
            	row.add(1);
            	result.add(row);
        	}
        	return result;
        }
        
    }

	public static void main(String[] args){
		/************测试下list是不是按引用的*************/
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		List<Integer> row = new ArrayList<Integer>();
//		row.add(1);
//    	result.add(row);
//    	
//    	row = new ArrayList<Integer>();
//    	row.add(2);
//    	result.add(row);
//    	for(List<Integer> i : result){
//    		System.out.println(i);
//    	}
    	
    	List<List<Integer>> result = generate(10);
    	for(List<Integer> i : result){
    		System.out.println(i);
    	}
		
	}
}
