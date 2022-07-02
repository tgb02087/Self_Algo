import java.io.*;
import java.util.*;

public class Main_bj_1654_랜선자르기 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1654.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] len = new int[K];
		long start = 0;
		long end = 0;
		for(int i=0; i<K; i++) {
			len[i]=Integer.parseInt(br.readLine());
			end = Math.max(end, len[i]);
		}
		// start=0, end=1일때 cur값이 0이 되어 0을 나누게되는것을 방지.
		end+=1;
		long cur=0;
		while(start<end) {
			cur = (start+end)/2;
			//System.out.println(cur);
			long cnt=0;
			for(int i=0; i<K; i++) {
				cnt+=(len[i]/cur);
			}
			if(cnt<N) {
				end=cur;
			}
			else {
				start=cur+1;
			}
		}
		System.out.println(start-1);
		br.close();
	}
}

