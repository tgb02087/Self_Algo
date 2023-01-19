# 📘 22251 (빌런 호석)

## 소요시간, 메모리

120ms, 11748KB

## 풀이 방법

- N까지의 모든 수를 X값으로 바꿀수 있는지 체크함
  - 자리수를 0으로 맞추기 위해 뒷자리부터 확인해보면서 서로 자리수를 맞춤
  - 예를 들어 355 와 2를 비교시
    - 1. 3, 2를
    - 2. 5, 0를
    - 3. 5, 0를 비교

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int[][] num = new int[][]{
            {0,4,3,3,4,3,2,3,1,2},
            {4,0,5,3,2,5,6,1,5,4},
            {3,5,0,2,5,4,3,4,2,3},
            {3,3,2,0,3,2,3,2,2,1},
            {4,2,5,3,0,3,4,3,3,2},
            {3,5,4,2,3,0,1,4,2,1},
            {2,6,3,3,4,1,0,5,1,2},
            {3,1,4,2,3,4,5,0,4,3},
            {1,5,2,2,3,2,1,4,0,1},
            {2,4,3,1,2,1,2,3,1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for(int i=1; i<=N; i++) {
            if(i==X) continue;
            if(led(X,i,P,K)) cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
    static boolean led(int x, int y, int p, int k) {
        while(true) {
            if(--k<0) return false;
            int n1 = x%10;
            int n2 = y%10;
            p-=num[n1][n2];
            if(p<0) return false;
            x /= 10;
            y /= 10;
            if(x==0 && y==0) break;
        }
        return true;
    }
}
```
