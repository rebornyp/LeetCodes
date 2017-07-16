package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 三数求和是0的存在，找出所有不同情况，并列成数组，存入list中；
 * @author Gastby
 *
 */
public class ThreeSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1,0,1,2,-1,-4};
//		int[] a = {};
		p(threeSum(a));
	}

	static List<List<Integer>> arr = new ArrayList<List<Integer>>();
	static public List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length < 3)
			return arr;
		Arrays.sort(nums);
		for(int i=0; i<nums.length-2; i++) {
			if(i > 0 && nums[i] == nums[i-1])
				continue;
			find(nums, i+1, nums.length-1, nums[i]);
		}
		return arr;
	}
	
	private static void find(int[] nums, int i, int j, int k) {
		// TODO Auto-generated method stub
		int start = i, end = j;
		while(i < j) {
			if(nums[i] + nums[j] == -k) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(nums[i]);
				l.add(nums[j]);
				l.add(k);
				arr.add(l);
				while(i < j && nums[i] == nums[i+1]) i++;
				while(i < j && nums[j] == nums[j-1]) j--;
				i ++;
				j --;
			} else if(nums[i] + nums[j] > -k)
				j --;
			else
				i ++;
		}
		
	}

	static void p(Object o) {
		System.out.println(o);
	}
	
}
