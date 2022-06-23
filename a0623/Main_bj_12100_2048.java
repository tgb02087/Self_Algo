package a0622;

import java.io.*;
import java.util.*;

public class Main_bj_12100_2048 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_12100.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] arr = new int[5];
		p(arr,0);
		br.close();
	}
	static void p(int[] arr, int idx) {
		if(idx==5) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=0; i<4; i++) {
			arr[idx]=i;
			p(arr,idx+1);
		}
	}
}
