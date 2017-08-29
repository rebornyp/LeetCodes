package test;

import java.util.Arrays;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(int i=0; i<256; i++) {
			System.out.println((char)i);
		}*/

/**
* this is just for funny
*/

		String s  = "sadfsqwertyiour";
		p(getMostLength(s));

	}

	private static int getMostLength(String s) {
		// TODO Auto-generated method stub
		int[] b = new int[256];
		int[] l = new int[s.length()];

		int n = s.length();

		for(int i=0; i<n; i++) {
			Arrays.fill(b, 0);
			char c = s.charAt(i);
			b[c]++;
			int j;
			for(j=i+1; j<n; j++) {
				if(++ b[s.charAt(j)]  == 2)
					break;
			}
			l[i] = j - i;
		}

		int temp = l[0];
		for(int i=1; i<n; i++) {
			if(l[i] > temp)
				temp = l[i];
		}

		return temp;
	}

	static void p(Object o) {
		System.out.println(o);
	}

}
