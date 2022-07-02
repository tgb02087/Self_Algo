package a0628.self;

import java.io.*;
import java.util.*;

public class Main_bj_2805_나무자르기2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int[] tree = new int[N];
		int max = 0;
		int min = 0;
		for(int i=0; i<N; i++) {
			tree[i]=Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		while(min<max) {
			long ans=0;
			int cur = (max+min)/2;
			for(int i=0; i<N; i++) {
				if(0<tree[i]-cur) ans+=tree[i]-cur;
			}
			if(ans<M) max=cur;
			else min=cur+1;
		}
		System.out.println(min-1);
		br.close();
	}
}
