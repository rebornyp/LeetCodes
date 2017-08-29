package LeetCode;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

public class HouseRobber {

    
    public static void main(String[] args) {
		PrintStream pw = System.out;
		int[] arr = {1, 5, 8, 9, 10, 17, 17, 20, 23, 25};
		Random r = new Random();
		int[] a = new int[1000];
		a[0] = 1;
		for(int i=1; i<a.length; i++) {
			a[i] = a[i-1] + r.nextInt(4);
		}
		int n = 10;
		pw.println(gold(arr, n));
		pw.println(gold3(arr, n));
	}
    
    /**
     * 自底向上的动态规划解法，时间复杂度也是n^2级别，但是代码更为简洁,
     * 还可求出最佳长度列表,j即完整的切割方案
     * @param a
     * @param n
     * @return
     */
    private static int gold3(int[] a, int n) {
    	PrintStream ps = System.out;
		int[] r = new int[n+1];
		int[] s = new int[n+1];
		r[0] = 0;
		int q;
		for(int i=1; i<=n; i++) {
			q = 0;
			for(int j=1; j<=i; j++) {
				if(q < a[j-1] + r[i - j]) {
					q = a[j-1] + r[i - j];
					s[i] = j; //给出求解钢条第一截取段的长度
				}
			}
			r[i] = q;
		}
		int f = r[n];
		ps.print("完整解决方案是：");
		while(n > 0) {
			ps.print(s[n] + "-");
			n = n - s[n];
		}
		ps.println();
    	return f;
	}
    
    

	/**
     * 普通，不高效的递归调用方法
     * @param arr
     * @param n
     * @return
     */
    private static int gold(int[] arr, int n) {
		if(n == 1)
			return arr[0];
		else {
			int q = 0;
			for(int i=1; i<n; i++)
				q = Math.max(q, gold(arr, i) + gold(arr, n - i));
			q = Math.max(q, arr[n - 1]);
			return q;
		}
	}

   /**
    * 自顶向下，加入备忘机制的动态规划算法,时间复杂度不再是指数级的了，而是n*n级别的
    * @param n
    * @return
    */
    private static int gold2(int[] arr, int n) {
    	if(n == 1)
			return arr[0];
    	int[] r = new int[n];
    	return gold2Main(arr, n, r);
    }
    
	private static int gold2Main(int[] arr, int n, int[] r) {
		if(r[n-1] > 0)
			return r[n-1];
		int q = 0;
		if(n == 1) {
			q = arr[0];
		} else {
			for(int i=1; i<n; i++) {
				q = Math.max(q, gold2Main(arr, n-i, r) + arr[i-1]);
			}
			q = Math.max(q, arr[n-1]);
		}
		r[n-1] = q;
		return q;
	}


	public static int rob(int[] arr) {
        if(arr == null || arr.length == 0)
			return 0;
		else if(arr.length == 1)
			return arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
		return dp[arr.length-1];
    }
}
