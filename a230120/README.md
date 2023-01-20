# 📘 2096 (내려가기)

## 소요시간, 메모리

324ms, 44732KB

## 풀이 방법

- 슬라이딩 윈도우와 DP를 사용
  - 입력받는 값을 map에 저장했다고하면
  - 점화식은 min[0] = min(min[0],min[1]) + map[0]
  - min[1] = min(min[0],min[1],min[2]) + map[1]
  - min[2] = min(min[1],min[2]) + map[2] 이 된다.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[] max = new int[3];
        int[] min = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<3; i++) {
            map[0][i] = Integer.parseInt(st.nextToken());
            min[i] = map[0][i];
            max[i] = map[0][i];
        }
        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++) map[i][j] = Integer.parseInt(st.nextToken());
            int bf_min0 = min[0];
            int bf_min1 = min[1];
            int bf_max0 = max[0];
            int bf_max1 = max[1];
            min[0] = Math.min(min[0],min[1]) + map[i][0];
            min[1] = Math.min(Math.min(bf_min0,min[1]),min[2]) + map[i][1];
            min[2] = Math.min(bf_min1,min[2]) + map[i][2];

            max[0] = Math.max(max[0],max[1]) + map[i][0];
            max[1] = Math.max(Math.max(bf_max0,max[1]),max[2]) + map[i][1];
            max[2] = Math.max(bf_max1,max[2]) + map[i][2];
        }
        sb.append(Math.max(Math.max(max[0],max[1]),max[2])).append(" ").append(Math.min(Math.min(min[0],min[1]),min[2]));
        System.out.println(sb);
        br.close();
    }
}
```
