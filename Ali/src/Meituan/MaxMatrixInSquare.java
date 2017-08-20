package Meituan;
/** 
* @author ZYJ 
* @version 创建时间：2017年8月20日 下午1:45:57 
* @Details 
* 题目描述
有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。
比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
测试样例：
[2,7,9,4,1],5
返回：14
*/
public class MaxMatrixInSquare {
	public int countArea(int[] A, int n) {
        // write code here
		int maxs = 0;
		for (int i = 0; i < A.length; i++) {
			int l = 0;
			int maxl=0;
			for (int j = 0; j < A.length; j++) {
				if(A[j]>=A[i]) l++;
				else l = 0;
				maxl = Math.max(maxl, l);
			}
			maxs = Math.max(maxs, maxl*A[i]);
		}
		return maxs;
    }
}
