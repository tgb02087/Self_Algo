# 📘 1920 (수 찾기)

## 소요시간, 메모리

580ms, 58244KB

## 풀이 방법

- 이분 탐색을 활용하여 품.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        Arrays.sort(arr);
        for(int i=0; i<M; i++) {
            int n = Integer.parseInt(st.nextToken());
            int first = 0;
            int end = N-1;
            int mid = (end-first)/2;
            while(true) {
                if(arr[mid] == n) {
                    sb.append("1").append('\n');
                    break;
                }
                if(end-first == 1) {
                    if(arr[first] == n) sb.append("1").append('\n');
                    else if(arr[end] == n) sb.append("1").append('\n');
                    else sb.append("0").append('\n');
                    break;
                }
                else if(end==first) {
                    if(arr[first] == n) sb.append("1").append('\n');
                    else sb.append("0").append('\n');
                    break;
                }
                if(arr[mid]<n) {
                    first = mid;
                    mid += (end-first)/2;
                }
                else {
                    end = mid;
                    mid -= (end-first)/2;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
```
