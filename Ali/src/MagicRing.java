import java.util.Arrays;
import java.util.Scanner;


/**
 * @author ZYJ
 * @version 创建时间：Aug 4, 2017 12:00:15 AM
 * @Details 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：
 *          每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),
 *          一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 *          输入描述:
 * 
 *          输入数据包括两行： 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 *          第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.
 * 
 * 
 * 
 *          输出描述:
 * 
 *          输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 * 
 * 
 *          输入例子1:
 * 
 *          3 2 
 *          1 2 3
 * 
 * 
 *          输出例子1:
 * 
 *          8 9 7
 * 
 */
public class MagicRing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		scan.nextLine();
		int[] ring = new int[n];
		for (int i = 0; i < n; i++) {
			ring[i] = scan.nextInt();
		}
		scan.close();
		//System.out.println(getRingStatus(n, k, ring));
		System.out.println(getRingStatus2(n,k,ring));
	}
	// 状态转移矩阵 C = A*B^k
	private static String getRingStatus2(int n, int k, int[] ring) {
		// TODO Auto-generated method stub
		int[][] markov = buildMatrix(n);
		
		int[][] res = {ring};
//使用快速幂运算求A×B^k
		while(k!=0){
			if((k&1)==1) res = multiplyTwpMatrix(res, markov);
			markov = multiplyTwpMatrix(markov, markov);
			
			k>>=1;
		}

		return Arrays.toString(res[0]).replace(", ", " ").replaceAll("[\\[\\]]", "");
	}

	private static int[][] matrixMulti(int n) {
		// TODO Auto-generated method stub
		int[][] markov = buildMatrix(n);
		int[][] re = new int[n][n];
		System.arraycopy(markov, 0, re, 0, re.length);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int tmp=0;
				for(int l=0;l<n;l++){
					if(markov[l][i]!=0)
						tmp += re[i][l]*markov[l][i];
				}
				re[i][j] =tmp;
			}
		}
		return re;
	}
	private static int[][] multiplyTwpMatrix(int[][] a, int[][] b) {
        int rowRes = a.length;
        int columnRes = b[0].length; //TODO:
        int columnA = a[0].length; // == b.length;
 
        int[][] c = new int[rowRes][columnRes];
        for (int i =0; i < rowRes; i ++) {
            for (int j = 0; j < columnRes; j ++) {
                for (int k = 0; k < columnA; k ++) {
                    if (a[i][k] == 0 || b[k][j] == 0) {
                        continue;          //剪枝
                    }
 
                    c[i][j] += a[i][k] * b[k][j];
                }
                //100取余运算
                if (c[i][j] >= 100) {
                    c[i][j] %= 100;
                }
            }
        }
        return c;
    }
	private static int[][] buildMatrix(int n) {
		// TODO Auto-generated method stub
		int[][] result = new int[n][n];
		for(int i=0;i<n-1;i++){
			result[i][i] = 1;
			result[i+1][i] = 1;
		}
		result[n-1][n-1] =1;
		result[0][n-1] = 1;
		return result;
	}
	private static String getRingStatus(int n, int k, int[] ring) {
		// TODO Auto-generated method stub
		//int[] tmp = new int[n];
		int tmp = ring[0];
		for (int i = 0; i < k; i++) {
			//System.arraycopy(ring, 0, tmp, 0, n);
			tmp = ring[0];
			for (int j = 0; j < n; j++) {
				if(j<n-1) ring[j] =(ring[j] + ring[j+1])%100;
				else ring[j] = (ring[j] + tmp)%100;
				System.out.println("tmp:"+tmp+" ring"+ring[j]);
			}
		}
		System.out.println(Arrays.toString(ring));
		return Arrays.toString(ring).replace(", ", " ").replaceAll("[\\[\\]]", "");
	}

}
